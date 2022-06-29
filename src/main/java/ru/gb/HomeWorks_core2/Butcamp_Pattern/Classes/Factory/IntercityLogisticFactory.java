package ru.gb.HomeWorks_core2.Butcamp_Pattern.Classes.Factory;

 /**
 * Фабрика межгородской службы доставки
 */


public class IntercityLogisticFactory implements LogisticFactory {

    @Override
    public Logistic createLogistic() {
        return new IntercityLogistic();
    }
}
