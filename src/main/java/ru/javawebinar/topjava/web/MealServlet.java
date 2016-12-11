package ru.javawebinar.topjava.web;


import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Sergey on 09.12.2016.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    private MealDaoImpl mealDao = new MealDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LOG.debug("redirect to meals");

        List<MealWithExceed> mealWithExceedList = MealsUtil.getWithExceeded(mealDao.list(), 2000);
        request.setAttribute("mealList", mealWithExceedList);

        String remove = request.getParameter("remove");
        if (remove != null) {
            mealDao.remove(Integer.parseInt(remove));
            response.sendRedirect("meals");
        }

        String edit = request.getParameter("edit");
        if (edit != null) {
            Meal meal = null;
            for (Meal m : mealDao.list()) {
                if (Integer.parseInt(edit) == m.getId()) {
                    meal = m;
                }
            }
            if (meal != null) {
                request.setAttribute("meal", meal);
            }
        }

        if (remove == null)
            request.getRequestDispatcher("meals.jsp").forward(request, response);

        //response.sendRedirect("meals.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        LOG.debug("redirect to meals!");

        String dateTime = req.getParameter("dateTime");
        String description = req.getParameter("description");
        String calories = req.getParameter("calories");
        String id = req.getParameter("id");
        LOG.debug(id);
        if (id == null){
            Meal meal = new Meal(LocalDateTime.parse(dateTime), description, Integer.parseInt(calories));
            mealDao.add(meal);
        } else {
            Meal meal = new Meal(Integer.parseInt(id), LocalDateTime.parse(dateTime), description, Integer.parseInt(calories));
            mealDao.update(meal);
        }


        doGet(req, resp);
    }
}
