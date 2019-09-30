package ua.ithillel.hw7.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerBasket implements Comparable<FlowerBasket> {

    private int flowerBasketID;
    private String flowerBasketName;
    private float fullPrice = 0.00f;
    private List<Flower> flowersBasketList = new ArrayList<Flower>();

    public FlowerBasket() {
    }

    public FlowerBasket(int flowerBasketID, String flowerBasketName) {
        this.flowerBasketID = flowerBasketID;
        this.flowerBasketName = flowerBasketName;
    }

    public FlowerBasket(int flowerBasketID, String flowerBasketName, List<Flower> fbl) {
        this.flowerBasketID = flowerBasketID;
        this.flowerBasketName = flowerBasketName;
        this.flowersBasketList = fbl;
    }

    public void calculateBasketPrice() {
        float tmpPrice = 0.00f;
        if (flowersBasketList.size() > 0) {
            for (Flower flower : flowersBasketList) {
                tmpPrice += flower.getFlowerPrice();
            }
        }
        this.fullPrice = tmpPrice;
    }


    public void addFlower(Flower flo) {
        flowersBasketList.add(flo);
//            if (flowersBasketList.length == 0) {
//                return new Flower[]{flo};
//            } else {
//                Flower[] newFlowerArr = new Flower[flowersBasketList.length + 1];
//
//                for (int i = 0; i < flowersBasketList.length; i++) {
//                    newFlowerArr[i] = flowersBasketList[i];
//                }
//                newFlowerArr[flowersBasketList.length] = flo;
//                return newFlowerArr;
//            }
        calculateBasketPrice();
    }

    public void removeFlower(int indexFlower) {
        flowersBasketList.remove(indexFlower);
        calculateBasketPrice();
    }

    public void listFlowerBasket() {
        StringBuilder listInfo = new StringBuilder();

        listInfo.append("Цветы в корзине" + getFlowerBasketName() + ":\n");
        for (Flower flower : this.flowersBasketList) {
            listInfo.append("Код: " + flower.getFlowerID())
                    .append(" Наименование: " + flower.getFlowerName())
                    .append(" Стоимость" + flower.getFlowerPrice() + "\n");
        }
        System.out.println(listInfo);
    }

    public List<Flower> getFlowersBasketList() {
        return flowersBasketList;
    }

    public void setFlowersBasketList(List<Flower> flowersBasketList) {
        this.flowersBasketList = flowersBasketList;
    }

    public Flower getFlowerItemIndex(int itemIndex) {
        return flowersBasketList.get(itemIndex);
    }

    public int getFlowerBasketCount() {
        return this.flowersBasketList.size();
    }

    public float getFullPrice() {
        return fullPrice;
    }

    public int getFlowerBasketID() {
        return flowerBasketID;
    }

    public void setFlowerBasketID(int flowerBasketID) {
        this.flowerBasketID = flowerBasketID;
    }

    public String getFlowerBasketName() {
        return flowerBasketName;
    }

    public void setFlowerBasketName(String flowerBasketName) {
        this.flowerBasketName = flowerBasketName;
    }


    @Override
    public int compareTo(FlowerBasket o) {
        return Float.compare(this.fullPrice, o.fullPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FlowerBasket)) return false;

        FlowerBasket that = (FlowerBasket) obj;

        if (flowerBasketID != that.flowerBasketID) return false;
        if (Float.compare(that.fullPrice, fullPrice) != 0) return false;
        if (!flowerBasketName.equals(that.flowerBasketName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowerBasketID;
        result = 10 * result + flowerBasketName.hashCode();
        result = 10 * result + (fullPrice != +0.00f ? Float.floatToRawIntBits(fullPrice) : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "Код:" + getFlowerBasketID() +
                ", Наименование корзины:" + getFlowerBasketName() + '\'' +
                ", Количество цветов:" + getFlowerBasketCount() +
                ", Стоимость цветов:" + getFullPrice() +
                '}';
    }
}
