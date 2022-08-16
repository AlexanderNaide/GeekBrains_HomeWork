package ru.gb.HomeWorks_core3.lesson1;

public class Orange extends Fruit{
    protected static String title = "Апельсины";
    protected static Float weight = 1.5f;

    public Orange(){
        title = "Апельсины";
        weight = 1.5f;
    }

    public static String getTitleFruit() {
        return title;
    }

    public static Float getWeightFruit() {
        return Orange.weight;
    }
}
