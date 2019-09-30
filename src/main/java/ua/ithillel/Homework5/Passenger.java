package Homework5;

public class Passenger extends Wheeled {
    private int numberOfSeats;
    private String category;

    private Transport transport;

    public Passenger(String name, int consumptionFuel, int speed, int price, int wheel, int numberOfSeats) {
        super(name, consumptionFuel, speed, price, wheel);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCategory() {
        return category;
    }

//    @Override
//    public void setCategory(String category) {
//        this.category = category;
//        transport = new Transport("BGL D3K2 XL", 80, 30, 2860000);
//    }
//
//    @Override
//    public void go() {
//        if (transport != null) {
//            System.out.println("GO!");
//        } else {
//            System.out.println("STOP! No transport");
//        }
//    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                ", consumptionFuel=" + getConsumptionFuel() +
                ", speed=" + getSpeed() +
                ", numberOfSeats=" + numberOfSeats +
                ", wheel=" + getWheel() +
                ", price=" + getPrice() +
                '}';
    }


}

