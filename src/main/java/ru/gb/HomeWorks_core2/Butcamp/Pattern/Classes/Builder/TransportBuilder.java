package ru.gb.HomeWorks_core2.Butcamp.Pattern.Classes.Builder;

/**
 * Строитель транспорта
 */

public abstract class TransportBuilder {

    LogisticTransport logisticTransport;

    void CreateLogisticTransport(){
        logisticTransport = new LogisticTransport();
    }

    abstract void BuildName();
    abstract void BuildTransport();
    abstract void BuildVolume();
    abstract void BuildBearingCapacity();

    LogisticTransport getLogisticTransport(){
        return logisticTransport;
    }

}
