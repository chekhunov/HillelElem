package Homework4;

class Recursion {
    void printRecursionNumber(int n) {
        if (n > 1)
            printRecursionNumber(n - 1);
        System.out.println(n);
    }
}

class TestRecursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.printRecursionNumber(6);
    }
}
