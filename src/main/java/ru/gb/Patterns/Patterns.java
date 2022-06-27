package ru.gb.Patterns;

public class Patterns {

    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("Singleton 1 - " + singleton1);
        System.out.println("Singleton 2 - " + singleton2);

        Multiton multiton1 = Multiton.getInstance("1");
        Multiton multiton2 = Multiton.getInstance("2");
        Multiton multiton3 = Multiton.getInstance("2");
        System.out.println(multiton1);
        System.out.println(multiton2);
        System.out.println(multiton3);

        LimitedMultiton limitedMultiton1 = LimitedMultiton.getInstance(LimitedMultiton.Count.ONE);
        LimitedMultiton limitedMultiton2 = LimitedMultiton.getInstance(LimitedMultiton.Count.TWO);
        LimitedMultiton limitedMultiton3 = LimitedMultiton.getInstance(LimitedMultiton.Count.THREE);
        LimitedMultiton limitedMultiton4 = LimitedMultiton.getInstance(LimitedMultiton.Count.THREE);
        System.out.println(limitedMultiton1);
        System.out.println(limitedMultiton2);
        System.out.println(limitedMultiton3);
        System.out.println(limitedMultiton4);




    }

}
