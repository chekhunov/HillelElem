package Homework2;

import java.util.Arrays;

public class Array {
    /**
     * Объявить массив с n-м количеством случайных чисел (явно инициализировать массив)
     * и выбрать из него четные и нечетные числа.
     */
    public void getArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.println(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println("четные" + arr[i]);
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.println("нечетные" + arr[i]);
            }
        }
    }

    /**
     * Объявить массив с n-м количеством случайных чисел (явно инициализировать массив)
     * и выбрать из него простые числа.
     */
    public void getArrayPrime(int n) {
        System.out.println();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            boolean isPrime = true;
            if (arr[i] == 1)
                isPrime = false;
            else {
                if (arr[i] == 0)
                    isPrime = false;
                else {
                    for (int j = 2; j <= arr[i] / 2; j++) {
                        if (arr[i] % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                if (isPrime)
                    System.out.println(arr[i] + " простое число в массиве ");
            }
        }
    }

    /**
     * Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран
     * (первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих)
     */
    public void arrayFibonachi() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            if (i < 2) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Объявить массив с n-м количеством случайных чисел (явно инициализировать массив)
     * и выбрать из него наибольшее и наименьшее число
     */
    public void getArrayMinMax(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.println(arr[i] + " ");
        }
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
    }

    /**
     * Умножить две матрицы
     */
    public void multiplyMatrix() {
        int[][] a = {{23, 44, 52}, {21, 13, 12}, {12, 14, 17}};
        int[][] b = {{14, 18, 51}, {5, 18, 49}, {36, 11, 71}};
        int m = a.length;
        int n = b[0].length;
        int o = b.length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.format("%6d ", res[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Задать массив с n чисел. Найти самое короткое и самое длинное число.
     * Вывести найденные числа и их длину.
     */
    public void findMaxMinLenghtValue(int n) {
        int[] arr = new int[n];
        int i = 0;
        for (; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.println(arr[i] + " ");
        }
        int size = Integer.toString(Integer.MAX_VALUE).length(), el = Integer.MAX_VALUE;
        for (int iterator : arr) {
            int itsize = Integer.toString(iterator).length();
            String siterator = Integer.toString(iterator);
            if (itsize < size) {
                size = itsize;
                el = iterator;
            }
        }
        System.out.println("Minimal length: " + size + " character in " + el + " element");


        size = 0;
        el = 0;
        for (int iterator : arr) {
            int itsize = Integer.toString(iterator).length();
            String siterator = Integer.toString(iterator);
            if (itsize > size) {
                size = itsize;
                el = iterator;
            }
        }
        System.out.println("Maximal length: " + size + " character in " + el + " element");
    }

    /**
     * Задать массив с n чисел. Найти числа, состоящее только из различных цифр.
     */
    public void findDifferentDigits(int n) {
        int[] arr = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int a = (int) (Math.random() * 1000);
            arr[i] = a;

            boolean isMatch = true;
            String num = String.valueOf(a);

            for (int x = 0; x < num.length(); ) {
                Character ch1 = num.charAt(x);

                for (int j = x + 1; j < num.length(); j++) {
                    Character ch2 = num.charAt(j);

                    if (ch1 == ch2) {
                        isMatch = false;
                    }
                }
                x++;
            }
            if (isMatch) {
                sorted[i] = a;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sorted));
    }


    /**
     * Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
     */
    public void printMatrixNN(int k) {
        int n = (int) Math.sqrt(k);
        int[][] arr = new int[n][n];
        int a = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a++;
                arr[i][j] = a;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

    }

}
