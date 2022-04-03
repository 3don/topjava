package ru.javawebinar.topjava.controller;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.MealServlet;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public interface MealControllerInterface {

    Meal getById(int id);
    List<Meal> getAll();
    void create(Meal meal);
    void update(int id, Meal meal);
    void delete(int id);

}
