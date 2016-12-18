package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collections;
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
    public void delete(int id) {
        if (repository.get(id).getUserId() == AuthorizedUser.id())
            repository.remove(id);
    }

    @Override
    public Meal get(int id) {
        return repository.get(id).getUserId() == AuthorizedUser.id() ? repository.get(id) : null;
    }

    @Override
    public List<Meal> getAll() {
        List<Meal> mealList = repository.values().stream().filter(meal -> meal.getUserId() == AuthorizedUser.id())
                .sorted((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()))
                .collect(Collectors.toList());
        return mealList == null ? Collections.emptyList() : mealList;
    }
}

