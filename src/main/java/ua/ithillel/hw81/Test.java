package ua.ithillel.hw81;

public class Test {

    private static void sumNum(String... args) {
        if (args.length != 0) {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("Результат сложения x + y = " + (x + y));
        }
    }

    public static void main(String[] args) {
        sumNum("12", "10");
    }
}