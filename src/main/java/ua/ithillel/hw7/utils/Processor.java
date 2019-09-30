package ua.ithillel.hw7.utils;

import ua.ithillel.hw7.classes.Flower;
import ua.ithillel.hw7.classes.FlowerBasket;
import ua.ithillel.hw7.enums.EnumFlowerCategory;

import java.io.*;
import java.util.Properties;

import static javax.xml.bind.DatatypeConverter.parseInt;

public class Processor {

    static void loadFlowerBasketProcessor(String fileName, FlowerBasket flowerBasket, String rowValue) {
        Properties proc = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(fileName);

            proc.load(input);

            autoLoadFlowersToBasket(proc, flowerBasket, rowValue);
            flowerBasket.calculateBasketPrice();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void autoLoadFlowersToBasket(Properties proc, FlowerBasket flowerBasket, String rowValue) {

        int fCount = Integer.parseInt(proc.getProperty("flowerCount"+ rowValue));

        int fCategory = 3;

        Flower flw;
        EnumFlowerCategory flowerCategory;

        int tmpFirstIndex = flowerBasket.getFlowersBasketList().size() + 1;
        fCount = (tmpFirstIndex - 1) + fCount;

        for (int i = tmpFirstIndex; i <= fCount; i++) {

            fCategory = Integer.parseInt(proc.getProperty("flowerCategory" + rowValue));
            switch (fCategory) {
                case 0:
                    flowerCategory = EnumFlowerCategory.PION;
                    break;
                case 1:
                    flowerCategory = EnumFlowerCategory.ROSA;
                    break;
                case 2:
                    flowerCategory = EnumFlowerCategory.ROMASHKA;
                    break;
                case 3:
                    flowerCategory = EnumFlowerCategory.OTHER_CATEGORY;
                    break;
                default:
                    flowerCategory = EnumFlowerCategory.OTHER_CATEGORY;
            }

            // используем для загрузки конструктор, который реализован в классе Flower
            flw = new Flower(i,
                    proc.getProperty("flowerName" + rowValue),
                    flowerCategory,
                    proc.getProperty("flowerCategoryName" + rowValue),
                    Integer.valueOf(proc.getProperty("flowerStemLength" + rowValue)),
                    Integer.valueOf(proc.getProperty("flowerManyDaysLeftFresh" + rowValue)),
                    Float.valueOf(proc.getProperty("flowerCost" + rowValue)));

            flowerBasket.addFlower(flw);
        }
    }

    private static void saveFlowerCategoryForStartup(Properties proc, String[] rowData, String rowValue) {
        proc.setProperty("flowerName" + rowValue, rowData[0].toString());
        proc.setProperty("flowerCategory" + rowValue, rowData[1].toString());
        proc.setProperty("flowerCategoryName" + rowValue, rowData[2].toString());
        proc.setProperty("flowerCount" + rowValue, rowData[3].toString());
        proc.setProperty("flowerCost" + rowValue, rowData[4].toString());
    }

    public static void savePropertiesStartupToFile(String fileName) {
        System.out.println("\nСоздаем файл с данными для автозагрузки в приложение");

        Properties proc = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(fileName);

            String[] row1 = {"Роза местная", "0", "Роза", "1", "20", "350.00"};
            saveFlowerCategoryForStartup(proc, row1, "1");
            proc.store(output, null);
            proc.clear();

            String[] row2 = {"Пион местный", "3", "Пион", "0", "50", "200.00"};
            saveFlowerCategoryForStartup(proc, row2, "2");
            proc.store(output, null);
            proc.clear();

            String[] row3 = {"Ромашка местная", "1", "Ромашка", "4", "15", "1000.00"};
            saveFlowerCategoryForStartup(proc, row3, "3");
            proc.store(output, null);
            proc.clear();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

