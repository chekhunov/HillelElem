package ua.ithillel.hw71.classes;

public class Flower extends BaseFlower {
    private int flowerStemLength;                       //длина стеБля
    private int flowerManyDaysLeftFresh;                //дней свежести

    public Flower(String name, float price, int flowerStemLength, int flowerManyDaysLeftFresh) {
        super(name, price);
        this.flowerStemLength = flowerStemLength;
        this.flowerManyDaysLeftFresh = flowerManyDaysLeftFresh;
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

    @Override
    public String toString() {
        return "Flower{" +
                "flowerStemLength=" + flowerStemLength +
                ", flowerManyDaysLeftFresh=" + flowerManyDaysLeftFresh +
                '}';
    }
}
