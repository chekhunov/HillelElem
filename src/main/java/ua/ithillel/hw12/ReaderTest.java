package ua.ithillel.hw12;

import ua.ithillel.hw12.storage.FileTextStorage;

import java.util.Arrays;

public class ReaderTest {
    public static void main(String[] args) {
        FileTextStorage storage =
                new FileTextStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw12/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw12/output.txt");

        System.out.print(Arrays.toString(storage.arrayFromFile()));
        System.out.println(storage.listFromFile());
        System.out.println(storage.getList());
        System.out.println(storage.toMap(storage.getList()));
        System.out.println(storage.reverse(storage.getList()));
        storage.writeText(String.valueOf(storage.reverse(storage.getList())));
    }
}
