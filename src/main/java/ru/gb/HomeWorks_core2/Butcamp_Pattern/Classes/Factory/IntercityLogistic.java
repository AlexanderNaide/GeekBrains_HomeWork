package ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory;

import ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory.Logistic;

public class IntercityLogistic implements Logistic {
    @Override
    public void LogisticGood() {
        System.out.println("Груз доставлен в другой город");
    }
}
