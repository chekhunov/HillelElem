package Homework1.maven;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        helloHuman();
        helloHumanRevers();
        getArray(5);
    }

    private static void helloHuman() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя для приветствия: ");
        String human = sc.nextLine();
        System.out.println("Приветствую тебя " + human + ".!");
    }

    private static void helloHumanRevers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя для приветствия: ");
        String human = sc.nextLine();
        String humanRevers = new StringBuffer(human).reverse().toString();
        System.out.println("Приветствую тебя " + humanRevers + ".!");
    }

    private static void getArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * n);
            System.out.println(arr[i]);
        }
        System.out.print(Arrays.toString(arr));
    }
}


