package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMealService service;

    public List<UserMealWithExceed> getAll() {
        LOG.info("getAll");
        return UserMealsUtil.getWithExceeded(service.getAll(LoggedUser.id()), LoggedUser.getCaloriesPerDay());
    }

    public UserMeal get(int mealId) {
        LOG.info("get " + mealId);
        return service.get(LoggedUser.id(), mealId);
    }

    public UserMeal save(int mealId,LocalDateTime dateTime,String parametr,int calories) {
        UserMeal userMeal = new UserMeal(mealId,dateTime,parametr,calories);
        LOG.info("create " + userMeal);
        return service.save(userMeal, LoggedUser.id());
    }

    public void delete(int mealId) {
        LOG.info("delete " + mealId);
        service.delete(LoggedUser.id(), mealId);
    }
}
