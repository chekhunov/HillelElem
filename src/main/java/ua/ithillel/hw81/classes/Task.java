package ua.ithillel.hw81.classes;

import java.util.Arrays;

class Task implements Runnable {

    private int from;
    private int to;

    Task(int from, int to) {
        this.from = from;
        this.to = to;
    }

    private boolean isPrimeNumber(int n) {
        boolean f = true;
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
                f = false;
                break;
            }
        }
        return f;
    }

    @Override
    public void run() {
        int[] arr = new int[to];
        int count = 0;
        for (int j = from; j <= to; j++) {
            if (j > 1 && isPrimeNumber(j)) {
                arr[count] = j;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}

