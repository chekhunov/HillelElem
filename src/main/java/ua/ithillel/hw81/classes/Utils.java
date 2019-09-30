package ua.ithillel.hw81.classes;


public class Utils {

    public void checkNumbersAtThreads(int threadCount, int numberMin, int numberMax) {

        int number = numberMax - numberMin;
        int part = number / threadCount;
        int temp = threadCount - 1;

        int from = 0;
        int to = number - (part * temp);


        for (int i = 0; i < threadCount; i++) {
            new Thread(new Task(from, to)).start();

            temp--;
            from = to + 1;
            to = number - (part * temp);
        }
    }
}