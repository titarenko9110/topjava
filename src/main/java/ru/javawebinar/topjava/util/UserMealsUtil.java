package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);

//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream()
                .collect(Collectors.groupingBy(p -> p.getDateTime().toLocalDate(), Collectors.summingInt(p -> p.getCalories())));
        return mealList.stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime().toLocalTime(), startTime, endTime))
                .map(p -> new UserMealWithExceed(p.getDateTime(), p.getDescription(), p.getCalories(), caloriesSumByDate.get(p.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());


//        ____________________________________________________________________________-first method
//        List<UserMealWithExceed> mealWithExceeds = new ArrayList<>();
//        for (int i = 0; i < mealList.size(); i++) {
//            UserMeal userMeal = mealList.get(i);
//            LocalDateTime localDateTime = userMeal.getDateTime();
//            LocalDate localDate = localDateTime.toLocalDate();
//            LocalTime localTime = localDateTime.toLocalTime();
//            int sumCalories = 0;
//            for (int j = 0; j < mealList.size(); j++) {
//                if (localDate.isEqual(mealList.get(j).getDateTime().toLocalDate()))
//                    sumCalories = sumCalories + mealList.get(j).getCalories();
//            }
//            if (sumCalories > caloriesPerDay && localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
//                mealWithExceeds.add(new UserMealWithExceed(localDateTime, userMeal.getDescription(), userMeal.getCalories(), true));
//            } else if (sumCalories <= caloriesPerDay && localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
//                mealWithExceeds.add(new UserMealWithExceed(localDateTime, userMeal.getDescription(), userMeal.getCalories(), false));
//            }
//        }
//
//        return mealWithExceeds;

//        ______________________________________________________________________________-second method
//        HashMap<LocalDate,Integer> dayWithSumCalories = new HashMap<>();
//
//        for (int i = 0; i < mealList.size(); i++) {
//            LocalDate date = mealList.get(i).getDateTime().toLocalDate();
//            int calories =  mealList.get(i).getCalories();
//            if(dayWithSumCalories.containsKey(date)){
//                int sumCalories = dayWithSumCalories.get(date) + calories;
//                dayWithSumCalories.put(date, sumCalories);
//            }else {
//                dayWithSumCalories.put(date, calories);
//            }
//        }
//        List<UserMealWithExceed> mealWithExceeds = new ArrayList<>();
//
//        for (int i = 0; i < mealList.size(); i++) {
//            UserMeal userMeal = mealList.get(i);
//            LocalDateTime localDateTime = userMeal.getDateTime();
//            if(localDateTime.toLocalTime().isBefore(endTime)&&localDateTime.toLocalTime().isAfter(startTime)){
//                LocalDate localDate = localDateTime.toLocalDate();
//                if(dayWithSumCalories.get(localDate)>caloriesPerDay){
//                    UserMealWithExceed userMealWithExceed = new UserMealWithExceed(userMeal.getDateTime(),userMeal.getDescription(),userMeal.getCalories(),true);
//                    mealWithExceeds.add(userMealWithExceed);
//                }else {
//                    UserMealWithExceed userMealWithExceed = new UserMealWithExceed(userMeal.getDateTime(),userMeal.getDescription(),userMeal.getCalories(),false);
//                    mealWithExceeds.add(userMealWithExceed);
//                }
//            }
//        }
//        return mealWithExceeds;
    }


}
