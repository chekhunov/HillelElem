package ua.ithillel.hw14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Processor {

    public int numberOfRepetitions(String text, String word) {
        long count = Arrays
                .stream(text.split("\\s+"))
                .filter(word::equals)
                .count();
        return Math.toIntExact(count);
    }

    public String replaceSymbol(String text) {

        String newText = Arrays.stream(text.split("\\s+"))
                .map(s1 -> {
                    if (s1.length() > 3) {
                        char[] tmp = s1.toCharArray();
                        tmp[3 - 1] = '@';
                        s1 = new String(tmp);
                    }
                    return s1;
                })
                .collect(Collectors.joining(" "));
        return newText;
    }

    public StringBuilder getLine(String... text) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(text));
        for (int j = 0; j < arrayList.size(); j++) {
            if (arrayList.get(j).charAt(0) == arrayList.get(j).charAt(arrayList.get(j).length() - 1)) {
                sb.append(arrayList.get(j)).append(" ");
                break;
            }
        }
        return sb;
    }

    public int findChar(String text) {

        char[] symbol = {','};
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < symbol.length; j++) {
                if (text.charAt(i) == symbol[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
