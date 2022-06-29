package ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory;

import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Builder.*;

import java.util.ArrayList;

/**
 * Фабрика городской службы доставки
 */

public class CityLogisticFactory implements LogisticFactory {

    @Override
    public Logistic createLogistic() {
        Logistic City = new СityLogistic();
        ArrayList <LogisticTransport> transports = new ArrayList<>();

        CreateTransport createTransport = new CreateTransport();

        createTransport.setBuilder(new GazelleBuilder());
        transports.add(createTransport.buildLogisticTransport());
        createTransport.setBuilder(new LargusBuilder());
        transports.add(createTransport.buildLogisticTransport());
        createTransport.setBuilder(new VeloBuilder());
        transports.add(createTransport.buildLogisticTransport());
        createTransport.setBuilder(new FootBuilder());
        transports.add(createTransport.buildLogisticTransport());

        double volume = 0;
        double capacity = 0;
        for (int i = 0; i < transports.size();) {
            LogisticTransport lt = transports.get(i);
            if (i == 0){
                volume = lt.getVolume();
                capacity = lt.getBearingCapacity();
            } else {
                if (volume < lt.getVolume() && capacity < lt.getBearingCapacity()){
                    i++;
                } else {
                    transports.add(i - 1, lt);
                }
            }
        }

        for (LogisticTransport transport : transports) {
            System.out.println(transport.getVolume() + " - " + transport.getBearingCapacity());
        }

        return new СityLogistic();
    }
}
