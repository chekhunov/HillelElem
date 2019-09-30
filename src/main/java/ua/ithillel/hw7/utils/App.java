package ua.ithillel.hw7.utils;

import ua.ithillel.hw7.classes.Flower;
import ua.ithillel.hw7.classes.FlowerBasket;
import ua.ithillel.hw7.classes.FlowerBouquet;
import ua.ithillel.hw7.classes.FlowerBouquetBasketShop;
import ua.ithillel.hw7.enums.EnumFlowerCategory;

import java.util.Collections;

import static ua.ithillel.hw7.classes.FlowerBouquetBasketShop.backFlowerBasket;
import static ua.ithillel.hw7.classes.FlowerBouquetBasketShop.searchFlowerBasketIndexIDCat;
import static ua.ithillel.hw7.utils.Processor.loadFlowerBasketProcessor;

public class App {
    public static FlowerBouquetBasketShop createShop() {
        System.out.println("\nСоздаем магазин объектов для работы приложения");

        return new FlowerBouquetBasketShop();
    }

    public static void workBasketsByMyShop(FlowerBouquetBasketShop myShop) {

        FlowerBasket flowersBasket1 = myShop.CreateFlowerBasket(1, "Корзина с пионами");
        FlowerBasket flowersBasket2 = myShop.CreateFlowerBasket(2, "Корзина с розами");
        FlowerBasket flowersBasket3 = myShop.CreateFlowerBasket(3, "Корзина с ромашками");

        // загрузим цветы в созданные корзины из параметров автозапуска

        loadFlowerBasketProcessor("load.processor", flowersBasket1, "0");
        // добавим еще одну розу в эту корзину через фабрику объектов для демонстрации возможностей фабрики
        Flower flowerRosa = myShop.CreateFlower((flowersBasket1.getFlowersBasketList().size() + 1),
                "Роза", "Роза местная",EnumFlowerCategory.ROSA,
                40,2,1500.00f);
        flowersBasket1.addFlower(flowerRosa);

        // загрузка цветов во 2 корзину
        loadFlowerBasketProcessor("load.processor", flowersBasket2, "1");

        // загрузка цветов в 3 корзину
        loadFlowerBasketProcessor("load.processor", flowersBasket3, "2");

        // сделаем вывод в консоль загруженных данных
        // в список корзин с цветами
        System.out.println("\nВыводим НЕ отсортированный по цене список корзин цветов");
        myShop.listBaskets();
        // теперь отсортируем список корзин с цветами по стоимости
        Collections.sort(myShop.getFlowerBasketList());
        // сделаем вывод списка еще раз
        System.out.println("\nВыводим отсортированный по цене список корзин цветов");
        myShop.listBaskets();
    }

    // демонстрирует возможности работы со списком букетов цветов при помощи магазина
    public static void workBouquetsByMyShop(FlowerBouquetBasketShop myShop) {

        System.out.println("\nСоздаем букеты цветов при помощи магазина");

        // Букет 1

        FlowerBouquet flwBouquet1 = myShop.CreateFlowerBouquet(1);
        int index = myShop.basketIndexID(myShop.getFlowerBasketList(), 1);
        FlowerBasket flwBasket1 = myShop.getFlowerBasketList().get(index);
        myShop.addFlowerBasketToBouquet(flwBasket1, flwBouquet1, EnumFlowerCategory.PION, "Пион", 350.00f, 2);

        // Букет 2
        FlowerBouquet flwBouquet2 = myShop.CreateFlowerBouquet(2);
        index = myShop.basketIndexID(myShop.getFlowerBasketList(), 2);
        FlowerBasket flwBasket2 = myShop.getFlowerBasketList().get(index);
        myShop.addFlowerBasketToBouquet(flwBasket2, flwBouquet2, EnumFlowerCategory.ROSA, "Роза", 200.00f, 3);

        // Букет 3
        FlowerBouquet flwBouquet3 = myShop.CreateFlowerBouquet(3);
        index = myShop.basketIndexID(myShop.getFlowerBasketList(), 3);
        FlowerBasket flwBasket4 = myShop.getFlowerBasketList().get(index);
        myShop.addFlowerBasketToBouquet(flwBasket4, flwBouquet3, EnumFlowerCategory.ROMASHKA, "Ромашка", 1000.00f, 7);

        // сделаем вывод в консоль загруженных данных
        // в список букетов с цветами
        System.out.println("\nВыводим НЕ отсортированный по цене список букетов цветов");
        myShop.listBouquet();
        // теперь отсортируем список букетов с цветами по стоимости
        Collections.sort(myShop.getFlowerBouquetList());
        // сделаем вывод списка еще раз
        System.out.println("\nВыводим отсортированный по цене список букетов цветов");
        myShop.listBouquet();

        System.out.println("\nВыводим содержание каждого букета из списка букетов");

        for (FlowerBouquet flwBouquet : myShop.getFlowerBouquetList()) {
            System.out.println(flwBouquet.toString());
            flwBouquet.listFlowerBouquet();
        }

        // вернем 2 цветка розы в корзину flwBasket1 из букета flwBouquet1
        System.out.println("\nВернем 2 цветка розы из 1 букета обратно в корзину");
        backFlowerBasket( flwBasket1,flwBouquet1, EnumFlowerCategory.ROSA, "Роза местная", 350.00f, 2);
        flwBouquet1.listFlowerBouquet();
        flwBasket1.listFlowerBasket();

        // отсортируем цветы в 1 корзине по цене
        System.out.println("\nСортируем цветы в 1 корзине по цене");
        Collections.sort(flwBasket1.getFlowersBasketList());
        flwBasket1.listFlowerBasket();
    }
}

