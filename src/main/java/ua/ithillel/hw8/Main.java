package ua.ithillel.hw8;

import Homework2.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int threadsCount = 3;
        PrimeNumbersStorage storage = new PrimeNumbersStorage();
        Thread[] threads = new Thread[threadsCount];

        threads[0] = new Thread(new PrimeNumbers(1, 33, storage));
        threads[1] = new Thread(new PrimeNumbers(34, 66, storage));
        threads[2] = new Thread(new PrimeNumbers(67, 100, storage));
        //...

//
      new Thread(new PrimeNumbers(1, 33, storage));
       new Thread(new PrimeNumbers(34, 66, storage));
        new Thread(new PrimeNumbers(67, 100, storage));

        //...
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Arrays.toString(storage.getNumbers()));
        }
    }
}
