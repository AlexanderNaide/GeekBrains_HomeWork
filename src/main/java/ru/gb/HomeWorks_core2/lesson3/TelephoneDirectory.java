package ru.gb.HomeWorks_core2.lesson3;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TelephoneDirectory {

    private final Map<String, String> directory;

    public TelephoneDirectory(){
        directory = new HashMap<>();
    }

    public void add(String name, String phone){
        directory.put(phoneReader(phone), name);
    }

    public void get(String name){
        System.out.println(name + ": ");
        if (!directory.containsValue(name)){
            System.out.println("Номер телефона не найден.");
        } else {
            directory.forEach((s, s2) -> {
                if (s2.equals(name)){
                    System.out.println(s);
                }
            });
        }
    }

        public String phoneReader(String phone){

        char[] phoneToChar = phone.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
            for (Character c :
                    phoneToChar) {
                characters.add(c);
            }

        return phone;
    }

/*    public String phoneReader(String phone){

        char[] list = phone.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(list[list.length - 1]);
        sb.append(list[list.length - 2]);
        sb.append('-');
        sb.append(list[list.length - 3]);
        sb.append(list[list.length - 4]);
        sb.append('-');
        sb.append(list[list.length - 5]);
        sb.append(list[list.length - 6]);
        sb.append(list[list.length - 7]);
        sb.append(')');
        sb.append(list[list.length - 8]);
        sb.append(list[list.length - 9]);
        sb.append(list[list.length - 10]);
        sb.append('(');
        sb.append('7');
        sb.append('+');
        sb.reverse();

        return sb.toString();
    }*/

    public void printDirectory(){
        directory.forEach((s, s2) -> System.out.println(s2 + " " + s));
    }

}
