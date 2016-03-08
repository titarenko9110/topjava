package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.UserMeal;

/**
 * Created by MyMac on 07.03.16.
 */
public interface UserMealCrud {
    UserMeal create(UserMeal userMeal);

    UserMeal get(Integer id);

    void delete(Integer id);

}
