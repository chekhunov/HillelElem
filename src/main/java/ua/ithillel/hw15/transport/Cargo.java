package ua.ithillel.hw15.transport;


import ua.ithillel.hw15.interfaces.ITransport;

public class Cargo extends Transport implements ITransport {
    private int loadCapacity;

    public Cargo(String name, int consumptionFuel, int speed, int price, int loadCapacity) {
        super(name, consumptionFuel, speed, price);
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
                "loadCapacity=" + loadCapacity +
                '}';
    }
}


