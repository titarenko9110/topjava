package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MyMac on 07.03.16.
 */
public class UserMealInMemory implements UserMealCrud {
    private Map<Integer,UserMeal>  memoryWithUserMeal = new ConcurrentHashMap<>();
    private static Integer id = 0;



    @Override
    public UserMeal create(UserMeal userMeal) {
        int userMealId = id++;
        if(userMeal.getId()==null){
            userMeal.setId(userMealId);
        }
        return memoryWithUserMeal.put(userMealId,userMeal);
    }

    @Override
    public UserMeal get(Integer id) {
      return memoryWithUserMeal.get(id);
    }

    @Override
    public void delete(Integer id) {
        memoryWithUserMeal.remove(id);
    }
}
