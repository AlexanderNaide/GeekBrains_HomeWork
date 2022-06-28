package ru.gb.Patterns;

import ru.gb.Patterns.Factory.*;

public class Patterns {

    public static void main(String[] args) {


        /***** Singlton & Multiton *****/

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


        /***** Фабрика обьектов / FactoryMethod *****/

        Store store = new GroceryStore();
        store.saleGood();

        StoreFactory storeFactory = new GroceryStoreFactory();
        Store storeGrocery = storeFactory.createStore();
        storeGrocery.saleGood();

        StoreFactory storeFactoryWear = new WearStoreFactory();
        Store storeWear = storeFactoryWear.createStore();
        storeWear.saleGood();




    }

}
