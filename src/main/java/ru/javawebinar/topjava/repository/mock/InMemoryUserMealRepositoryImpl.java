package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, Map<Integer, UserMeal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    private static Map<Integer, UserMeal> meal = new ConcurrentHashMap<>();
    public static Comparator<UserMeal> DATE_TIME_COMPARATOR = (o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime());

    {
        save(new UserMeal(LocalDateTime.now(), "csc", 1000),1);
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        } else if (get(userId, userMeal.getId()) == null) {
            return null;
        }

        meal.put(userMeal.getId(), userMeal);
        repository.put(userId,meal);
        return userMeal;

    }

    @Override
    public boolean delete(int userId, int mealId) {
        Map<Integer,UserMeal> meals = repository.get(userId);
        if(meals != null && meals.get(mealId)!=null){
            meals.remove(mealId);
            return true;
        }else return false;
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        return userMeals == null ? null : userMeals.get(mealId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        Map<Integer,UserMeal> meals = repository.get(userId);
        List<UserMeal> result = new ArrayList<>(meals.values());
        Collections.sort(result,DATE_TIME_COMPARATOR);
        return result;
    }
}
