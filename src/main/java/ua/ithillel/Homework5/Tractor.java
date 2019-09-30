package Homework5;

public class Tractor extends Crawler {
    private int traction;

    public Tractor(String name, int consumptionFuel, int speed, int price, int weight, int traction) {
        super(name, consumptionFuel, speed, price, weight);
        this.traction = traction;
    }

    public int getTraction() {
        return traction;
    }

    public void setTraction(int traction) {
        this.traction = traction;
    }

    @Override
    public String toString() {
        return "Tractor{" +
                "name='" + getName() + '\'' +
                ", consumptionFuel=" + getConsumptionFuel() +
                ", speed=" + getSpeed() +
                ", traction=" + traction +
                ", price=" + getPrice() +
                ", weight=" + getWeight() +
                '}';
    }
}
