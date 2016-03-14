package ru.javawebinar.topjava;

import java.time.LocalDate;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello Topjava Enterprise!");
        LocalDate l = LocalDate.parse("2013-12-01");
        System.out.println(l);
    }
}
