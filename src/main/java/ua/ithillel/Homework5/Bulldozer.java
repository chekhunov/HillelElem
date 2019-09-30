package Homework5;

public class Bulldozer extends Crawler {
    private int bucketVolume;

    public Bulldozer(String name, int consumptionFuel, int speed, int price, int weight, int bucketVolume) {
        super(name, consumptionFuel, speed, price, weight);
        this.bucketVolume = bucketVolume;
    }

    public int getBucketVolume() {
        return bucketVolume;
    }

    public void setBucketVolume(int bucketVolume) {
        this.bucketVolume = bucketVolume;
    }

    @Override
    public String toString() {
        return "Bulldozer{" +
                "name='" + getName() + '\'' +
                ", consumptionFuel=" + getConsumptionFuel() +
                ", speed=" + getSpeed() +
                ", bucketVolume=" + bucketVolume +
                ", price=" + getPrice() +
                ", weight=" + getWeight() +
                '}';
    }
}
