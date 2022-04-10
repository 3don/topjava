package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal extends AbstractBaseEntity {

    private final LocalDateTime dateTime;

    private final String description;

    private final int userId;

    private final int calories;

    public Meal(LocalDateTime dateTime, String description, int userId, int calories) {
        this(null, dateTime, description, userId, calories);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int userId, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.userId = userId;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
