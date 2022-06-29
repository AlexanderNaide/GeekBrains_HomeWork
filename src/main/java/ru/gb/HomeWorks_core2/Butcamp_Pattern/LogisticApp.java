package ru.gb.HomeWorks_core2.Butcamp_Pattern;

import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Builder.*;
import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory.CityLogisticFactory;
import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory.IntercityLogisticFactory;
import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory.Logistic;
import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory.LogisticFactory;
import ru.gb.Patterns.Factory.GroceryStoreFactory;
import ru.gb.Patterns.Factory.Store;
import ru.gb.Patterns.Factory.StoreFactory;
import ru.gb.Patterns.Factory.WearStoreFactory;

public class LogisticApp {
    public static void main(String[] args) {

        CreateTransport createTransport = new CreateTransport();

        createTransport.setBuilder(new GazelleBuilder());
        LogisticTransport ltg = createTransport.buildLogisticTransport();
        createTransport.setBuilder(new LargusBuilder());
        LogisticTransport ltl = createTransport.buildLogisticTransport();
        createTransport.setBuilder(new VeloBuilder());
        LogisticTransport ltv = createTransport.buildLogisticTransport();
        createTransport.setBuilder(new FootBuilder());
        LogisticTransport ltf = createTransport.buildLogisticTransport();

        System.out.println(ltg);
        System.out.println(ltl);
        System.out.println(ltv);
        System.out.println(ltf);


        LogisticFactory logisticFactoryInterCity = new IntercityLogisticFactory();
        Logistic intercity = logisticFactoryInterCity.createLogistic();
        intercity.LogisticGood();

        LogisticFactory logisticFactoryCity = new CityLogisticFactory();
        Logistic city = logisticFactoryCity.createLogistic();
        city.LogisticGood();
    }
}
