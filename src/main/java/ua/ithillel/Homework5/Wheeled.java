package Homework5;

public class Wheeled extends Transport {
    private int wheel;

    public Wheeled(String name, int consumptionFuel, int speed, int price, int wheel) {
        super(name, consumptionFuel, speed, price);
        this.wheel = wheel;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Wheeled{" +
                "name='" + getName() + '\'' +
                ", consumptionFuel=" + getConsumptionFuel() +
                ", speed=" + getSpeed() +
                ", price=" + getPrice() +
                ", wheel=" + wheel +
                '}';
    }
}
