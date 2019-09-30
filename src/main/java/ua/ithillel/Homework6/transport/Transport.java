package Homework6.transport;

import Homework6.interfaces.ITransport;

public class Transport implements ITransport {
    private String name;
    private int consumptionFuel;
    private int speed;
    private int price;

    public Transport(String name, int consumptionFuel, int speed, int price) {
        this.name = name;
        this.consumptionFuel = consumptionFuel;
        this.speed = speed;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConsumptionFuel() {
        return consumptionFuel;
    }

    public void setConsumptionFuel(int consumptionFuel) {
        this.consumptionFuel = consumptionFuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", consumptionFuel=" + consumptionFuel +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}




