package ru.gb.HomeWorks_core2.Butcamp.Pattern.Classes.Factory;

import ru.gb.HomeWorks_core2.Butcamp.Pattern.Classes.Builder.*;

import java.util.ArrayList;

/**
 * Фабрика городской службы доставки
 */

public class CityLogisticFactory implements LogisticFactory {

    @Override
    public Logistic createLogistic() {
        СityLogistic cityLogistic = new СityLogistic();
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
        for (int j = 0; j < transports.size(); j++) {
            for (int i = 0; i < transports.size() - j;) {
                LogisticTransport lt = transports.get(i);
                if (i == 0 || (volume < lt.getVolume() && capacity < lt.getBearingCapacity())){
                    volume = lt.getVolume();
                    capacity = lt.getBearingCapacity();
                    i++;
                } else {
                    transports.remove(i);
                    transports.add(i - 1, lt);
                    volume = lt.getVolume();
                    capacity = lt.getBearingCapacity();
                }
            }
        }

//        for (LogisticTransport transport : transports) {
//            System.out.println(transport.getVolume() + " - " + transport.getBearingCapacity());
//        }

        cityLogistic.setLogisticTransports(transports);
        return cityLogistic;
    }
}
