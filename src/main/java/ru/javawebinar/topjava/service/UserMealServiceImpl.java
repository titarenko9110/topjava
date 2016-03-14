package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        return repository.save(userMeal,userId);
    }

    @Override
    public void delete(int userId, int mealId)  throws NotFoundException {
        ExceptionUtil.check(repository.delete(userId,mealId), mealId);
    }

    @Override
    public UserMeal get(int userId, int mealId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(userId,mealId), mealId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }
}
