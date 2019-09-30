package ua.ithillel.hw7;
import ua.ithillel.hw7.classes.FlowerBouquetBasketShop;
import ua.ithillel.hw7.utils.App;


import static ua.ithillel.hw7.utils.App.*;
import static ua.ithillel.hw7.utils.Processor.savePropertiesStartupToFile;

public class Test {

    public static void main(String[] args) {
        // загружаем автопараметры для запуска приложения в файл типа Properties
        savePropertiesStartupToFile("load.processor");


        // создадим фабрику объектов для работы приложения
        FlowerBouquetBasketShop myShop = createShop();

        // демонстрация работы со списком объектов, содержащего корзины цветов
        workBasketsByMyShop(myShop);

        // демонстрация работы со списком объектов, содержащего букеты цветов
        workBouquetsByMyShop(myShop);

    }
}