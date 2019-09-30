package ua.ithillel.hw14;

import java.util.Arrays;

public class mainTest {
    public static void main(String[] args) {

        String text = "text hello text text,";
        String word = "text";
        String[] array = text.split(" ");

        Processor processor = new Processor();

        System.out.println(processor.numberOfRepetitions(text, word));
        System.out.println(processor.replaceSymbol(text));
        System.out.println(processor.findChar(text));

        StringBuilder stringBuilder = new Processor().getLine("text", "hello", "text", "text");
        System.out.println(stringBuilder);

        System.out.println(Arrays.toString(array));
        StringBuilder stringBuilder1 = new Processor().getLine(array);
        System.out.println(stringBuilder1);
    }
}
