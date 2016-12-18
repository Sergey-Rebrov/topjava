package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 15.06.2015.
 */
public interface MealService {

    Meal save(Meal meal);

    void delete(int id) throws NotFoundException;

    Meal get(int id) throws NotFoundException;

    List<MealWithExceed> getAll();

    List<MealWithExceed> getAll(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime);
}
