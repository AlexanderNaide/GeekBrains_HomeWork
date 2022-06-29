package ru.gb.Patterns;

import ru.gb.Patterns.Builder.Director;
import ru.gb.Patterns.Builder.HeavyIndustrialUnitBuilder;
import ru.gb.Patterns.Builder.IndustrialUnit;
import ru.gb.Patterns.Builder.LightIndustrialUnitBuilder;
import ru.gb.Patterns.EasyBuilder.Report;
import ru.gb.Patterns.Factory.*;
import ru.gb.Patterns.Singleton.LimitedMultiton;
import ru.gb.Patterns.Singleton.Multiton;
import ru.gb.Patterns.Singleton.Singleton;

public class Patterns {

    public static void main(String[] args) {


        /***** Singlton & Multiton *****/

        System.out.println("\n*********** Singleton ***********");
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("Singleton 1 - " + singleton1);
        System.out.println("Singleton 2 - " + singleton2);

        System.out.println("\n*********** Multiton ***********");
        Multiton multiton1 = Multiton.getInstance("1");
        Multiton multiton2 = Multiton.getInstance("2");
        Multiton multiton3 = Multiton.getInstance("2");
        System.out.println(multiton1);
        System.out.println(multiton2);
        System.out.println(multiton3);

        System.out.println("\n*********** Limited Multiton ***********");
        LimitedMultiton limitedMultiton1 = LimitedMultiton.getInstance(LimitedMultiton.Count.ONE);
        LimitedMultiton limitedMultiton2 = LimitedMultiton.getInstance(LimitedMultiton.Count.TWO);
        LimitedMultiton limitedMultiton3 = LimitedMultiton.getInstance(LimitedMultiton.Count.THREE);
        LimitedMultiton limitedMultiton4 = LimitedMultiton.getInstance(LimitedMultiton.Count.THREE);
        System.out.println(limitedMultiton1);
        System.out.println(limitedMultiton2);
        System.out.println(limitedMultiton3);
        System.out.println(limitedMultiton4);


        /***** Фабрика обьектов / FactoryMethod *****/

        System.out.println("\n*********** FactoryMethod ***********");
        Store store = new GroceryStore();
        store.saleGood();

        StoreFactory storeFactory = new GroceryStoreFactory();
        Store storeGrocery = storeFactory.createStore();
        storeGrocery.saleGood();

        StoreFactory storeFactoryWear = new WearStoreFactory();
        Store storeWear = storeFactoryWear.createStore();
        storeWear.saleGood();


        /***** Строитель / Builder *****/
        System.out.println("\n*********** Builder ***********");
        Director director = new Director();
        director.setBuilder(new LightIndustrialUnitBuilder());
        IndustrialUnit industrialUnit = director.buildIndustrialUnit();
        System.out.println(industrialUnit);

        director.setBuilder(new HeavyIndustrialUnitBuilder());
        System.out.println(director.buildIndustrialUnit());

        /***** Строитель в одном классе / EasyBuilder *****/
        System.out.println("\n*********** EasyBuilder ***********");
        Report report = new Report.Builder("Отчет за 1 квартал 2022")
                .setTitle("Закупка")
                .setContent("Реализовано успешно")
                .setTable("Таблица цен")
                .setPageNumber(1)
                .build();

        System.out.println(report);
        System.out.println(report.getHeader());
        System.out.println(report.getContent());

    }
}
