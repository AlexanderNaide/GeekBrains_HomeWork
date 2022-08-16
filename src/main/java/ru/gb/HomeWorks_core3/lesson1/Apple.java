package ru.gb.HomeWorks_core3.lesson1;

public class Apple extends Fruit{
    protected static String title = "Яблоки";
    protected static Float weight = 1.0f;

    public Apple(){
//        title = "Яблоки";
//        weight = 1.0f;
    }

    public static String getTitleFruit() {
        return title;
    }

    public static Float getWeightFruit() {
        return Apple.weight;
    }
}
