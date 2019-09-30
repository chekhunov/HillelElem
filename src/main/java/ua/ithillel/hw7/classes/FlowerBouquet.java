package ua.ithillel.hw7.classes;

import java.util.ArrayList;
import java.util.List;

public class FlowerBouquet implements Comparable<FlowerBouquet> {

    private int flowerBouquetID;
    private List<Flower> flowerBouquetList = new ArrayList<Flower>();
    private float fullPrice = 0.00f;

    public FlowerBouquet() {
    }

    public FlowerBouquet(int flowerBouquetID) {
        this.flowerBouquetID = flowerBouquetID;
    }

    public FlowerBouquet(int flowerBouquetID, List<Flower> flowerBl) {
        this.flowerBouquetID = flowerBouquetID;
        this.flowerBouquetList = flowerBl;
    }



    public void addFlower(Flower flowerBa) {
        flowerBouquetList.add(flowerBa);
        calculateBouquetPrice();
    }

    public void removeFlower(int indexFlower) {
        flowerBouquetList.remove(indexFlower);
        calculateBouquetPrice();
    }

    public void listFlowerBouquet() {
        StringBuilder listInfo = new StringBuilder().append("\n Список цветов в букете "+this.getFlowerBouquetID()+":");

        for (Flower flower : this.flowerBouquetList) {
            listInfo.append("Код: " + flower.getFlowerID())
                    .append(" Категория: " + flower.getFlowerName())
                    .append(" Стоимость" + flower.getFlowerPrice() + "\n");
        }
        System.out.println(listInfo);
    }

    public void calculateBouquetPrice() {
        float tmpPrice = 0.00f;
        if (flowerBouquetList.size() > 0) {
            for (Flower flower : flowerBouquetList) {
                tmpPrice += flower.getFlowerPrice();
            }
        }
        this.fullPrice = tmpPrice;
    }
    public List<Flower> getFlowerBouquetList() {
        return flowerBouquetList;
    }

    public void setFlowerBouquetList(List<Flower> flowerBo) {
        this.flowerBouquetList = flowerBo;
    }

    public Flower getFlowerItemIndex(int itemIndex) {
        return flowerBouquetList.get(itemIndex);
    }

    public int getFlowerBouquetCount() {
        return this.flowerBouquetList.size();
    }

    public float getFullPrice() {
        return fullPrice;
    }

    public void setFlowerBouquetID(int flowerBouquetID) {
        this.flowerBouquetID = flowerBouquetID;
    }

    public int getFlowerBouquetID() {
        return flowerBouquetID;
    }

    @Override
    public int compareTo(FlowerBouquet o) {
        return Float.compare(this.fullPrice, o.fullPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FlowerBouquet)) return false;

        FlowerBouquet that = (FlowerBouquet) obj;

        if (flowerBouquetID != that.flowerBouquetID) return false;
        if (Float.compare(that.fullPrice, fullPrice) != 0) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = flowerBouquetID;
        result = 10 * result + (fullPrice != +0.00f ? Float.floatToIntBits(fullPrice) : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "Код:" + getFlowerBouquetID() +
                ", Количество цветов:" + getFlowerBouquetCount() +
                ", Стоимость цветов:" + getFullPrice() +
                '}';
    }
}
