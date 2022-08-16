package ru.gb.HomeWorks_core3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {

        /**
         * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
         */

        String[] arrayString = {"Кафе", "Кино", "Боулинг"};
        System.out.println(Arrays.toString(arrayString));
        replacingElement(arrayString, 1, 2);
        System.out.println(Arrays.toString(arrayString));

        Integer[] arrayInt = {9, 5, 7};
        System.out.println(Arrays.toString(arrayInt));
        replacingElement(arrayInt, 1, 2);
        System.out.println(Arrays.toString(arrayInt));


        /**
         * 2. Написать метод, который преобразует массив в ArrayList;
         */

        ArrayList<String> listString = conversionToArrayList(arrayString);
        System.out.println(listString);
        ArrayList<Integer> listInt = conversionToArrayList(arrayInt);
        System.out.println(listInt);


        /**
         * 3. Большая задача.
         */

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.getWeight();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.getWeight();
        System.out.println("Результат сравнения: " + appleBox.compare(orangeBox));
        orangeBox.addFruit(new Orange());
        orangeBox.getWeight();
        System.out.println("Результат сравнения: " + appleBox.compare(orangeBox));

    }

    public static <T> void replacingElement(T[] array, int a, int b) { // 1. Метод меняет два элемента массива местами.
        T t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public static <T> ArrayList<T> conversionToArrayList(T[] array) { // 2. Метод преобразует массив в ArrayList.
        ArrayList<T> list = new ArrayList<>(array.length + 1); // Ну вдруг массив придет очень большим - сразу сэкономим на перезаписи.
        list.addAll(Arrays.asList(array));
        return list;
    }
}
