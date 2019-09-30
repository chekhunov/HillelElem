package ua.ithillel.hw12.interfaces;

import java.util.List;
import java.util.Map;

public interface TextStorage {

    String[] arrayFromFile();

    void writeText(String textToWrite);

    Map<String, Integer> toMap(List<String> list);
}
