package Homework5;

public class Crawler extends Transport{
private int weight;

    public Crawler(String name, int consumptionFuel, int speed, int price, int weight) {
        super(name, consumptionFuel, speed, price);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Crawler{" +
                "name='" + getName() + '\'' +
                ", consumptionFuel=" + getConsumptionFuel() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                "weight=" + weight +
                '}';
    }
}
