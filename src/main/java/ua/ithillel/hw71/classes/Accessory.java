package ua.ithillel.hw71.classes;

import ua.ithillel.hw71.classes.BaseFlower;

public class Accessory extends BaseFlower {
    private int packaging;

    public Accessory(String name, float price, int packaging) {
        super(name, price);
        this.packaging = packaging;
    }

    public int getPackaging() {
        return packaging;
    }

    public void setPackaging(int packaging) {
        this.packaging = packaging;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "packaging=" + packaging +
                '}';
    }
}
