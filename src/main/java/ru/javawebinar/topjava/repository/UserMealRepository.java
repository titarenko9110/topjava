package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {

    UserMeal save(UserMeal userMeal, int userId);

    boolean delete(int userId, int mealId);

    UserMeal get(int userId, int mealId);

    List<UserMeal> getAll(int userId);
}
