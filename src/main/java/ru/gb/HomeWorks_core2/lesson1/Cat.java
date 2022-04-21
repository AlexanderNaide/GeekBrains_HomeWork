package ru.gb.HomeWorks_core2.lesson1;

public class Cat implements Run{

    private int possibleDistance ;
    private double possibleBarrier;

    public Cat(int distance, double barrier){
        possibleDistance = distance;
        possibleBarrier = barrier;
    }

    @Override
    public void jump(Wall wall) {
        if (possibleBarrier > wall.getBarrier()) {
            System.out.printf("Я кот и я прыгнул на %s метра.", wall.getBarrier());
        } else {
            System.out.printf("Я кот и барьер %s метра для меня непреодалим.", wall.getBarrier());
        }
    }

    @Override
    public void run(Treadmill treadmill) {
        if (possibleDistance > treadmill.getDistance()) {
            System.out.printf("Я кот и я пробежал %s метров.", treadmill.getDistance());
        } else {
            System.out.printf("Я кот и дистанция %s метров для меня недостижима.", treadmill.getDistance());
        }
    }
}
