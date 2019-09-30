package Homework4;

public class SumNumbers {
    int printSumRecursionNumber(int n) {
        if (n > 0) {
            return n + printSumRecursionNumber(n - 1);
        } else {
            return n;
        }
    }
}

class TestSumNumbers {
    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers.printSumRecursionNumber(5));
    }
}

