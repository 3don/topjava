package ru.javawebinar.topjava.controller;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.InMemoryMeal;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealControllerInMemmory implements MealControllerInterface {
    private static final Logger log = getLogger(MealControllerInMemmory.class);
    List<Meal> meals = InMemoryMeal.meals;

    @Override
    public Meal getById(int id) {
        return meals.stream().filter(m-> m.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }

    @Override
    public void create(Meal meal) {
        log.debug("create meal");
        meals.add(meal);
    }

    @Override
    public void update(int id, Meal meal) {
        log.debug("update meal");
        meals.set(meals.indexOf(getById(id)), meal);
    }

    @Override
    public void delete(int id) {
        log.debug("delete meal");
        if (getById(id)!=null) meals.remove(getById(id));
    }
}
