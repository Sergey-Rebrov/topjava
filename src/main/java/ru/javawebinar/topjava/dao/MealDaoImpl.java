package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Sergey on 10.12.2016.
 */
public class MealDaoImpl implements DAO<Meal> {
    private static final Logger LOG = getLogger(MealDaoImpl.class);

    private static List<Meal> meals = new ArrayList<>();

    static {
        meals.add(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        meals.add(new Meal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        meals.add(new Meal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        meals.add(new Meal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        meals.add(new Meal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        meals.add(new Meal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

        @Override
        public void add (Meal meal){
            meals.add(meal);
            LOG.info("Meal successfully added. Meal details: " + meal);
        }

        @Override
        public void update (Meal meal){
            int id = meal.getId();
            for (int i = 0; i < meals.size(); i++) {
                if (id == meals.get(i).getId())
                    meals.set(i, meal);
            }
            LOG.info("Meal successfully updated. Meal details: " + meal);
        }

        @Override
        public void remove ( int id){
            for (int i = 0; i < meals.size(); i++)
            {
                if (id == meals.get(i).getId())
                    meals.remove(i);
            }
        }

        @Override
        public Meal getByID ( int id){
            Meal meal = null;
            for (Meal m : meals)
            {
                if (id == m.getId())
                    meal = m;
            }
            return meal;
        }

        @Override
        public List<Meal> list () {
            List<Meal> mealList = meals;
            for (Meal m : mealList)
                LOG.info("Meal list: " + m);
            return mealList;
        }

    public static synchronized int getMaxId() {
        int maxId = 0;
        for (Meal meal : meals) {
            if (maxId < meal.getId())
                maxId = meal.getId();
        }
        return maxId;
    }
}
