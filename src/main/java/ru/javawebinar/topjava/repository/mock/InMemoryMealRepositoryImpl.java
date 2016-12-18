package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryMealRepositoryImpl.class);

    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
        } else {
            if (meal.getUserId() == AuthorizedUser.id())
                repository.put(meal.getId(), meal);
        }
        return meal;
    }

    @Override
    public Meal delete(int id) {
        if (repository.get(id).getUserId() == AuthorizedUser.id())
            return repository.remove(id);
        return null;
    }

    @Override
    public Meal get(int id) {
        return repository.get(id).getUserId() == AuthorizedUser.id() ? repository.get(id) : null;
    }

    @Override
    public List<Meal> getAll() {
        return getAll(null, null, null, null);
    }

    @Override
    public List<Meal> getAll(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        List<Meal> mealList = repository.values().stream()
                .filter(meal -> meal.getUserId() == AuthorizedUser.id())
                .filter(meal -> DateTimeUtil.isBetween(meal.getDate()
                        , startDate == null ? LocalDate.MIN : startDate
                        , endDate == null ? LocalDate.MAX : endDate))
                .filter(meal -> DateTimeUtil.isBetween(meal.getTime()
                        , startTime == null ? LocalTime.MIN : startTime
                        , endTime == null ? LocalTime.MAX : endTime))
                .sorted((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()))
                .collect(Collectors.toList());
        return mealList;
    }
}

