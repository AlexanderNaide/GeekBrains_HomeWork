package ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory;

import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Builder.LogisticTransport;
import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory.Logistic;

import java.util.ArrayList;

public class СityLogistic implements Logistic {

    public ArrayList<LogisticTransport> logisticTransports;

    public void setLogisticTransports(ArrayList<LogisticTransport> logisticTransports) {
        this.logisticTransports = logisticTransports;
    }

    @Override
    public void LogisticGood() {
        System.out.println("Груз доставлен по городу");
    }
}
