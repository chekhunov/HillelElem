package Homework5;

public class Cargo extends Wheeled {
    private int loadCapacity;

    public Cargo(String name, int consumptionFuel, int speed, int price, int wheel, int loadCapacity) {
        super(name, consumptionFuel, speed, price, wheel);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + getName() + '\'' +
                ", consumptionFuel=" + getConsumptionFuel() +
                ", speed=" + getSpeed() +
                "loadCapacity=" + loadCapacity +
                ", wheel=" + getWheel() +
                ", price=" + getPrice() +
                '}';
    }
}
