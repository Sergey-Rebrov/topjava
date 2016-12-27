package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.*;

/**
 * Created by Sergey on 26.12.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceTest {

    @Autowired
    private
    MealService service;

    @Autowired
    private
    DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        Meal meal = service.get(MEAL1_ID, USER_ID);
        MealTestData.MATCHER.assertEquals(meal, MEAL1);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(MEAL1_ID, USER_ID);
        MealTestData.MATCHER.assertCollectionEquals(Collections.singletonList(MEAL3), service.getAll(ADMIN_ID));
        MealTestData.MATCHER.assertCollectionEquals(Collections.singletonList(MEAL2), service.getAll(USER_ID));
    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {
        Collection<Meal> meals = service.getBetweenDateTimes(LocalDateTime.of(2016, 12, 25, 0, 0), LocalDateTime.of(2016, 12, 25, 23, 59), USER_ID);
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(MEAL2, MEAL1), meals);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<Meal> all = service.getAll(USER_ID);
        all.addAll(service.getAll(ADMIN_ID));
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(MEAL2, MEAL1, MEAL3), all);
    }

    @Test
    public void testUpdate() throws Exception {
        Meal meal = new Meal(MEAL1);
        meal.setDescription("ЗЗЗЗЗавтрак");
        meal.setCalories(111);
        service.update(meal, USER_ID);
        MealTestData.MATCHER.assertEquals(meal, service.get(MEAL1_ID, USER_ID));
    }

    @Test
    public void testSave() throws Exception {
        Meal meal = new Meal(LocalDateTime.now(), "Перекус", 330);
        Meal newMeal = service.save(meal, USER_ID);
        meal.setId(newMeal.getId());
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(meal, MEAL2, MEAL1), service.getAll(USER_ID));
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.delete(MEAL1_ID, ADMIN_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundGet() throws Exception {
        service.get(MEAL1_ID, ADMIN_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundUpdate() throws Exception {
        Meal meal = new Meal(MEAL1);
        meal.setDescription("ЗЗЗЗЗавтрак");
        meal.setCalories(111);
        service.update(meal, ADMIN_ID);
    }

}