package ua.ithillel.hw7.classes;

import ua.ithillel.hw7.enums.EnumFlowerCategory;
import ua.ithillel.hw7.interfaces.InterfaceFlowerSale;

import java.util.*;

public class Flower extends AbstractFlower implements InterfaceFlowerSale, Comparable<Flower> {

    private int flowerID;
    private String flowerName;
    private EnumFlowerCategory flowerCategory; //категория цветка
    private String flowerCategoryName;         //категория цветка в тектовом виде
    private int flowerStemLength;                    //длина стеБля
    private int flowerManyDaysLeftFresh;             //дней свежести :)
    private float flowerPrice;

    public Flower(int flowerID, String flowerName, EnumFlowerCategory flowerCategory, String flowerCategoryName, int flowerStemLength, int flowerManyDaysLeftFresh, float flowerPrice) {
        super(flowerID, flowerName, flowerCategoryName, flowerCategory);

        this.flowerStemLength = flowerStemLength;
        this.flowerManyDaysLeftFresh = flowerManyDaysLeftFresh;
        this.flowerPrice = flowerPrice;
    }

    public int getFlowerStemLength() {
        return flowerStemLength;
    }

    public void setFlowerStemLength(int flowerStemLength) {
        this.flowerStemLength = flowerStemLength;
    }

    public int getFlowerManyDaysLeftFresh() {
        return flowerManyDaysLeftFresh;
    }

    public void setFlowerManyDaysLeftFresh(int flowerManyDaysLeftFresh) {
        this.flowerManyDaysLeftFresh = flowerManyDaysLeftFresh;
    }

    public float getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(float flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;

        Flower flower = (Flower) o;

        if (this.flowerID != flower.flowerID) return false;
        if (this.flowerName.equals(flower.flowerName)) return false;
        if (this.flowerCategory != flower.flowerCategory) return false;
        if (this.flowerCategoryName.equals(flower.flowerCategoryName)) return false;
        if (this.flowerStemLength != flower.flowerStemLength) return false;
        if (this.flowerManyDaysLeftFresh != flower.flowerManyDaysLeftFresh) return false;
        if (this.flowerPrice != flower.flowerPrice) return false;

        return true;
    }

    @Override
    public String getFlowerNameCategory(EnumFlowerCategory nc) {
        return null;
    }

    @Override
    public int compareTo(Flower o) {
        return Float.compare(this.flowerPrice, o.flowerPrice);
    }

    @Override
    public String toString() {
        return getClass().getName() + " " +
                "Код:" + flowerID +
                ", Цена:" + flowerPrice +'\'' +
                ", Категория:" + flowerCategoryName + '\'' +
                '}';
    }

    @Override
    public int hashCode(){
        int result = super.hashCode();
        result = 10* result+(flowerPrice!=+0.00f ? Float.floatToIntBits(flowerPrice):0);
        return result;
    }
}
