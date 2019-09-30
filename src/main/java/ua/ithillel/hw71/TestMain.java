package ua.ithillel.hw71;

import ua.ithillel.hw71.classes.Bouquet;
import ua.ithillel.hw71.classes.Flower;
import ua.ithillel.hw71.utils.Printer;

import java.util.Arrays;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet(5);

        Flower pion = new Flower("Пион", 25, 40, 5);
        Flower rosa = new Flower("Роза", 35, 70, 7);
        Flower romashka = new Flower("Ромашка", 20, 30, 4);
        Flower astra = new Flower("Астра", 25, 40, 5);
        Flower tulpan = new Flower("Тюльпан", 20, 25, 7);

        bouquet.addFlower(pion);
        bouquet.addFlower(rosa);
        bouquet.addFlower(romashka);
        bouquet.addFlower(astra);
        bouquet.addFlower(tulpan);

//        Printer.printBouquet(bouquet.getFlowers());
//        Printer.printPrice(bouquet.getBouquetCost());
        Flower[] allFlower = new Flower[]{pion, rosa, romashka, astra, tulpan};

        menuCreateBouquet(bouquet, allFlower);
    }

    private static int userNumber() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static void menuCreateBouquet(Bouquet bouquet, Flower[] allFlower) {
        System.out.println("\n1.Создать букет\r\n" + "2.Операции с букетом\r\n" + "0.Выход ");
        boolean noExit = true;
        while (noExit) {
            switch (userNumber()) {

                case 0:
                    noExit = false;
                    System.out.println("");
                    break;
                case 1: //create bouquet
                        menuCreateBouquet1(bouquet, allFlower);
                    break;
                case 2: //properties bouquet
                        menuCreateBouquet2();
                    break;
            }
        }
    }

    public static void menuCreateBouquet1(Bouquet bouquet,Flower[] allFlower) {
        System.out.println("\n1.Выбрать цветок\r\n" + "2.Выбрать аксессуар\r\n" + "0.Выход ");
        boolean noExit = true;
        while (noExit) {
            switch (userNumber()) {

                case 0:
                    noExit = false;
                    System.out.println("");
                    break;
                case 1: //выбрать цветок
                    //Printer.printBouquet(bouquet.getFlowers());
                    //System.out.println(Arrays.toString(allFlower));

                    break;
                case 2: //выбрать аксессуар

                    break;
            }
        }
    }

    public static void menuCreateBouquet2() {
        System.out.println("\n1.Сортировать букет\r\n" + "2.Стоимость букета\r\n" + "0.Выход ");
        boolean noExit = true;
        while (noExit) {
            switch (userNumber()) {

                case 0:
                    noExit = false;
                    System.out.println("");
                    break;
                case 1: //сортировать

                    break;
                case 2: //стоимость

                    break;
            }
        }
    }

}
