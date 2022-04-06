package ru.gb.HomeWorks.lesson6;

public class Dog extends Animal{

    protected final int limitRun = 500;
    protected final int limitSwing = 10;

    public Dog(String name){
        this.name = name;
    }

    public void run(int meter){
        if (meter > limitRun) {
            meter = limitRun;
        }
        super.run(meter);
    }
    public void swing(int meter){
        if (meter > limitSwing) {
            meter = limitSwing;
        }
        super.swing(meter);
    }
}
