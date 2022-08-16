package ru.gb.HomeWorks_core3.lesson1;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> list;
    private String type;
    private Float weightFruit;



    public Box() {
        list = new ArrayList<>();
        type = T.getTitleFruit();
        weightFruit = T.getWeightFruit();
        System.out.println(type);
        System.out.println(weightFruit);
    }

    public void addFruit(T t) {
        list.add(t);
    }

    public void getWeight() {
        System.out.printf("Коробка, содержащая %s имеет вес %.2f.\n", type, (list.size() * weightFruit));
    }

    public ArrayList<T> getList() {
        return list;
    }

    public Float getBoxWeight() {
        return list.size() * weightFruit;
    }

    public boolean compare(Box<? extends Fruit> box) {
        if (box == null){
            return false;
        }
        if (this.list.size() == 0){
            return box.getList().size() == 0;
        }
//        Fruit thisFruit = list.get(0);
//        Fruit anotherFruit = box.getList().get(0);
        System.out.println("1 - " + this.getBoxWeight());
        System.out.println("2 - " + box.getBoxWeight());

        return Math.abs(list.size() * T.getWeightFruit() - box.getList().size() * T.getWeightFruit()) < 0.0001;
//        return Math.abs(list.size() * thisFruit.getWeightFruit() - box.getList().size() * anotherFruit.getWeightFruit()) < 0.0001;
    }
}
