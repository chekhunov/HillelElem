package ua.ithillel.hw12.storage;

import ua.ithillel.hw12.interfaces.TextStorage;

import java.io.*;
import java.util.*;

public class FileTextStorage implements TextStorage {

    private List<String> list;
    private String inputFile;
    private String outputFile;

    public FileTextStorage() {
        list = new ArrayList<>();
    }

    public FileTextStorage(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public String[] arrayFromFile() {

        FileInputStream fis = null;
        byte[] readBytes = new byte[0];
        try {
            fis = new FileInputStream(inputFile);
            readBytes = new byte[fis.available()];
            fis.read(readBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file = new String(readBytes);
        String[] array = file.split(",");

        return array;
    }

    public List<String> listFromFile() {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    public StringBuffer reverse(List<String> list) {
        StringBuffer buffer = new StringBuffer(String.valueOf(list));
        buffer.reverse();
        return buffer;
    }

    public Map<String, Integer> toMap(List<String> list) {

        Map<String, Integer> map = new HashMap<>();

        list.forEach(line -> {
            String words[] = line.split(" ");

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                    continue;
                }
                map.put(word, 1);
            }
        });
//        String listNew = String.valueOf(list);
//        listNew = listNew.toLowerCase();
//        listNew = listNew.replaceAll("\\W", " ");
//            Map<String, Integer> map = new HashMap<>();
//        for(String s: listNew.split(" ")) {
//            if(map.containsKey(s)) {
//                map.put(s, map.get(s) + 1);
//            }
//            else {
//                map.put(s, 1);
//            }
//        }
//        map.remove("");
        return map;
    }

    @Override
    public void writeText(String text) {
        FileOutputStream fos = null;
        byte[] readBytes1 = new byte[text.length()];
        try {
            fos = new FileOutputStream(new File(outputFile));
            readBytes1 = text.getBytes();
            fos.write(readBytes1, 0, readBytes1.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getList() {
        return list = Arrays.asList(arrayFromFile());
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

}
