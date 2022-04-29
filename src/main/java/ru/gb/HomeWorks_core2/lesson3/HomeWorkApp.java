package ru.gb.HomeWorks_core2.lesson3;

import java.util.*;
import java.util.function.BiConsumer;

public class HomeWorkApp {
    public static void main(String[] args) {


        /************    Задание 1    ************/

        List<String> list = new ArrayList<>();

        list.add("January");
        list.add("February");
        list.add("March");
        list.add("February");
        list.add(3, "April");
        list.set(4, "May");
        list.addAll(Arrays.asList("June", "July", "May", "August", "September", "May", "October", "April"));
        list.addAll(List.of("November", "December"));

        Map<String, Integer> map = new LinkedHashMap<>();
        list.forEach(s -> {
            if (map.containsKey(s)) map.put(s, map.get(s)+1);
            else map.put(s, 1);
        });
        System.out.println(list);

        map.forEach((s, integer) -> System.out.println(s + " (" + integer + ")"));


        /************    Задание 2    ************/
        System.out.println();

        TelephoneDirectory directory = new TelephoneDirectory();

        directory.add("Иванов", "+79997773240");
        directory.add("Грибанов Серый", "89083201610");
        directory.add("Иванов", "89194652142");
        directory.add("Самойлов Глеб", "89997778888");
        directory.add("Иванов", "89203245159");
        System.out.println("-------------------");
//        directory.get("Самойлов Глеб");
        directory.get("Иванов");
//        directory.get("Приют для котиков");
    }
}
