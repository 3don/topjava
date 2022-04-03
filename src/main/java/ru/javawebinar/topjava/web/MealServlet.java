package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.controller.MealControllerInMemmory;
import ru.javawebinar.topjava.controller.MealControllerInterface;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    MealControllerInterface mealController = new MealControllerInMemmory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = action == null ? "" : action.toLowerCase();
        switch (action) {
            case "update":
                log.debug("redirect to update meals");
                request.setAttribute("meal", mealController.getById(parseInt(request.getParameter("mealId"))));
                request.setAttribute("action", "Edit");
                request.setAttribute("meal",
                        mealController.getById(parseInt(request.getParameter("mealId"))));
                request.getRequestDispatcher("/createEditMeal.jsp").forward(request, response);
                break;
            case "create":
                log.debug("redirect to create meals");
                request.setAttribute("action", "Create");
                request.getRequestDispatcher("/createEditMeal.jsp").forward(request, response);
                break;
            case "delete":
                log.debug("delete meal by id");
                mealController.delete(parseInt(request.getParameter("mealId")));
                response.sendRedirect("meals");
                break;
            default:
                log.debug("redirect to meals");
                response.setContentType("text/html;charset=utf-8");
                List<MealTo> mealsTo = MealsUtil.filteredByStreams(mealController.getAll(), LocalTime.MIN, LocalTime.MAX, MealsUtil.CALORIES_PER_DAY);
                request.setAttribute("meals", mealsTo);
                request.getRequestDispatcher("meals.jsp").forward(request, response);
        }
        //    response.sendRedirect("meals.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Meal meal;
        LocalDateTime ldt = LocalDateTime.now();
        ldt = !request.getParameter("date_time").isEmpty() ?
                LocalDateTime.parse(request.getParameter("date_time")) : ldt;
        String description = request.getParameter("description");
        int calories = parseInt(request.getParameter("calories"));
        if (request.getParameter("id").isEmpty()) {
            meal = new Meal(ldt, description, calories);
            mealController.create(meal);
        } else {
            int id = parseInt(request.getParameter("id"));
            meal = new Meal(id, ldt, description, calories);
            mealController.update(id, meal);
        }
        response.sendRedirect("meals");
    }

    private int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
