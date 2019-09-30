package ua.ithillel.hw9.transport;


import ua.ithillel.hw9.interfaces.ITransport;

public class Passenger extends Transport implements ITransport {
    private int numberOfSeats;

    public Passenger(String name, int consumptionFuel, int speed, int price, int numberOfSeats) {
        super(name, consumptionFuel, speed, price);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "numberOfSeats=" + numberOfSeats +
                '}';
    }
}

