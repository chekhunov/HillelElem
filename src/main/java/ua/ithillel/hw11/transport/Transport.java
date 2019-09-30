package ua.ithillel.hw11.transport;


import ua.ithillel.hw11.interfaces.ITransport;

import java.util.ArrayList;
import java.util.Comparator;

public class Transport extends ArrayList<Transport> implements ITransport, Comparable<Transport>, Comparator<Transport> {
    private String name;
    private int consumptionFuel;
    private int speed;
    private int price;

    public Transport(Transport transport1) {
    }

    public Transport(String name, int fuel) {

        this.name = name;
        this.consumptionFuel = fuel;
    }

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

    @Override
    public int compareTo(Transport t) {
        //return name.compareToIgnoreCase(t.getName());
        return (this.consumptionFuel - t.consumptionFuel);
    }

    @Override
    public int compare(Transport o1, Transport o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object o) {
        return name.compareToIgnoreCase((((Transport) o).getName())) == 0;
    }

}





