package ua.ithillel.hw81;

import ua.ithillel.hw81.classes.Utils;

import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число потоков ");
        int thread = scan.nextInt();
        System.out.println("Введите число MIN от 1 до 10000");
        int numberMin = scan.nextInt();
        System.out.println("Введите число MAX от 1 до 10000");
        int numberMax = scan.nextInt();


        Utils utils = new Utils();
        utils.checkNumbersAtThreads(thread, numberMin, numberMax);
    }
}

