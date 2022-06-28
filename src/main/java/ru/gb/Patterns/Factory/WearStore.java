package ru.gb.Patterns.Factory;

/**
 * Магазин одежды
 */

public class WearStore implements Store {
    @Override
    public void saleGood() {
        System.out.println("Симпотная маечка.");
    }
}
