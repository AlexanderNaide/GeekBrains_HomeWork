package ru.gb.HomeWorks_core2.Butcamp.Hash;

public class Solution {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>();
        System.out.println(table.contains("jfjfodolfkbmn"));
        table.put("jfjfodolfkbmn");
        System.out.println(table.contains("jfjfodolfkbmn"));
        table.remove("jfjfodolfkbmn");
        System.out.println(table.contains("jfjfodolfkbmn"));
    }
}
