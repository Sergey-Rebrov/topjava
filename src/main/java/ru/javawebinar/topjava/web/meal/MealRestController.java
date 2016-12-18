package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<MealWithExceed> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public List<MealWithExceed> getAll(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        LOG.info("getAll");
        return service.getAll(startDate, endDate, startTime, endTime);
    }

    public Meal delete(int id) {
        LOG.info("delete " + id);
        return service.delete(id);
    }

    public Meal get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public Meal save(Meal meal) {
        LOG.info("save " + meal);
        return service.save(meal);
    }
}
