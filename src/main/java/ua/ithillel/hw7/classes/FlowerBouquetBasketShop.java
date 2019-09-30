package ua.ithillel.hw7.classes;

import ua.ithillel.hw7.enums.EnumFlowerCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация магазина цветов
 */

public class FlowerBouquetBasketShop {
    private List<FlowerBouquet> flowerBouquetList = new ArrayList<FlowerBouquet>();

    private List<FlowerBasket> flowerBasketList = new ArrayList<FlowerBasket>();

    public FlowerBouquetBasketShop() {
    }

    public Flower CreateFlower(int flowerID, String flowerName, String flowerCategoryName, EnumFlowerCategory flowerCategory,
                               int flowerStemLength, int flowerManyDaysLeftFresh, float flowerPrice) {
        return new Flower(flowerID, flowerName, flowerCategory, flowerCategoryName, flowerStemLength,
                flowerManyDaysLeftFresh, flowerPrice);
    }

    public FlowerBasket CreateFlowerBasket(int flowerBasketID, String flowerBasketName) {
        FlowerBasket result = new FlowerBasket(flowerBasketID, flowerBasketName);

        flowerBasketList.add(result);
        return result;
    }

    public FlowerBouquet CreateFlowerBouquet(int flowerBouquetID) {
        FlowerBouquet result = new FlowerBouquet(flowerBouquetID);

        flowerBouquetList.add(result);

        return result;
    }

    public float calculateFlowerBasketListPrice() {
        float result = 0.00f;

        if (flowerBasketList.size() > 0) {
            for (FlowerBasket basket : flowerBasketList) {
                result += basket.getFullPrice();
            }
        }
        return result;
    }

    public float calculateFlowerBouquetListPrice() {
        float result = 0.00f;

        if (flowerBouquetList.size() > 0) {
            for (FlowerBouquet bouquet : flowerBouquetList) {
                result += bouquet.getFullPrice();
            }
        }
        return result;
    }

    public static int basketIndexID(List<FlowerBasket> flowerBasketList, int dID) {
        int i = -1;

        if (flowerBasketList.size() > 0) {
            i = 0;
            for (FlowerBasket basket : flowerBasketList) {
                if (dID == basket.getFlowerBasketID()) {
                    break;
                }
                i++;
            }
        }
        return i;
    }

    public static int bouquetIndexID(List<FlowerBouquet> flowerBouquetList, int dID) {
        int i = -1;

        if (flowerBouquetList.size() > 0) {
            i = 0;
            for (FlowerBouquet bouquet : flowerBouquetList) {
                if (dID == bouquet.getFlowerBouquetID()) {
                    break;
                }
                i++;
            }
        }
        return i;
    }

    public static int searchFlowerBasketIndexIDCat(FlowerBasket fBasket, EnumFlowerCategory fCategory,
                                                   String fFlowerName, float fPrice) {
        int i = -1;

        if (fBasket.getFlowersBasketList().size() > 0) {
            i = 0;
            for (Flower flower : fBasket.getFlowersBasketList()) {
                if (flower.getFlowerCategory() == fCategory
                        && flower.getFlowerName().equals(fFlowerName)
                        && flower.getFlowerPrice() == fPrice) {
                    break;

                } else {
                    if (flower.getFlowerCategory() == fCategory
                            && flower.getFlowerName().equals(fFlowerName)
                            && flower.getFlowerPrice() == fPrice) {
                        break;
                    }
                }
                i++;
            }
        }
        return i;
    }

    public static int searchFlowerBouquetIndexIDCat(FlowerBouquet fBouquet, EnumFlowerCategory fCategory,
                                                    String fFlowerName, float fPrice) {
        int i = -1;

        if (fBouquet.getFlowerBouquetList().size() > 0) {
            i = 0;
            for (Flower flower : fBouquet.getFlowerBouquetList()) {
                if (flower.getFlowerCategory() == fCategory
                        && flower.getFlowerName().equals(fFlowerName)
                        && flower.getFlowerPrice() == fPrice) {
                    break;

                } else {
                    if (flower.getFlowerCategory() == fCategory
                            && flower.getFlowerName().equals(fFlowerName)
                            && flower.getFlowerPrice() == fPrice) {
                        break;
                    }
                }
                i++;
            }
        }
        return i;
    }

    public static void addFlowerBasketToBouquet(FlowerBasket fromBasket, FlowerBouquet toFBouquet,
                                                EnumFlowerCategory fCategory, String fFlowerName,
                                                float fPrice, int fCount) {
        int currentIndexFlower;

        for (int i = 0; i < fCount; i++) {
            currentIndexFlower = searchFlowerBasketIndexIDCat(fromBasket, fCategory, fFlowerName, fPrice);
            if (currentIndexFlower == -1) {
                System.out.println("Цветок отсутствует в корзине!");
                break;
            } else {
                toFBouquet.addFlower(fromBasket.getFlowerItemIndex(currentIndexFlower));

                fromBasket.removeFlower(currentIndexFlower);
            }
        }
    }

    public static void backFlowerBasket(FlowerBasket fromBasket, FlowerBouquet toFBouquet,
                                        EnumFlowerCategory fCategory, String fFlowerName,
                                        float fPrice, int fCount) {
        int currentIndexFlower;

        for (int i = 0; i < fCount; i++) {
            currentIndexFlower = searchFlowerBouquetIndexIDCat(toFBouquet, fCategory, fFlowerName, fPrice);

            if (currentIndexFlower == -1) {
                System.out.println("Цветок отсутствует в букете!");
                break;
            } else {
                fromBasket.addFlower(toFBouquet.getFlowerItemIndex(currentIndexFlower));

                toFBouquet.removeFlower(currentIndexFlower);
            }
        }
    }

    public void listBaskets() {
        StringBuilder listInfo = new StringBuilder();

        listInfo.append("\nВсего корзин с цветами: ")
                .append(flowerBasketList.size())
                .append("\nОбщая стоимость корзин с цветами: ")
                .append(calculateFlowerBasketListPrice())
                .append(" \nСписок корзин состоит из: ");

        for (FlowerBasket basket : this.flowerBasketList) {
            listInfo.append("\n Код: ")
                    .append(basket.getFlowerBasketID())
                    .append(" Наименование корзины: ")
                    .append(basket.getFlowerBasketName())
                    .append(" Количество цветов в корзине: ")
                    .append(basket.getFlowerBasketCount())
                    .append(" Стоимость корзины: ")
                    .append(basket.getFullPrice());
        }

        System.out.println(listInfo);
    }

    public void listBouquet() {
        StringBuilder listInfo = new StringBuilder();

        listInfo.append("\nВсего букетов с цветами: ")
                .append(flowerBouquetList.size())
                .append("\nОбщая стоимость букетов с цветами: ")
                .append(calculateFlowerBouquetListPrice())
                .append(" \nСписок букетов состоит из: ");

        for (FlowerBouquet bouquet : this.flowerBouquetList) {
            listInfo.append("\n Код: ")
                    .append(bouquet.getFlowerBouquetID())
                    .append(" Количество цветов в букете: ")
                    .append(bouquet.getFlowerBouquetCount())
                    .append(" Стоимость букета: ")
                    .append(bouquet.getFullPrice());
        }

        System.out.println(listInfo);
    }

    public List<FlowerBouquet> getFlowerBouquetList() {
        return flowerBouquetList;
    }

    public void setFlowerBouquetList(List<FlowerBouquet> flowerBouquetList) {
        this.flowerBouquetList = flowerBouquetList;
    }

    public List<FlowerBasket> getFlowerBasketList() {
        return flowerBasketList;
    }

    public void setFlowerBasketList(List<FlowerBasket> flowerBasketList) {
        this.flowerBasketList = flowerBasketList;
    }
}
