package ru.gb.Bootcamp.Algorithms.Armstrong;

import java.util.Date;

public class Logger {

    private final Date startDate = new Date();
    public static boolean show = false;

    public void log(int value){
        if (show){
            long diffTimes = new Date().getTime() - startDate.getTime();
//        System.out.println((diffTimes / 1000) + " found armstrong number: " + value);
            System.out.println((diffTimes) + " found armstrong number: " + value);
        }
    }
}
