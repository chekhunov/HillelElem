package ua.ithillel.hw71.utils;

import ua.ithillel.hw71.classes.Flower;

public class Printer {
    public static void printBouquet(Flower[] flowers) {
        StringBuilder listInfo = new StringBuilder(flowers.length);
        listInfo.append("[ ");
        for (Flower flower : flowers) {
            listInfo.append(flower.getName());
            listInfo.append(" ");
        }
        listInfo.append(" ]");
        System.out.println(listInfo.toString());
    }

    public static void printPrice(float price) {
        System.out.println("Стоимость букета " + price);
    }
}
