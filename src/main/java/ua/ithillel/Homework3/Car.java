package Homework3;

public class Car {
    private static long nextId = 1;

    private long idNum = nextId++;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private long registrationNumber;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    Car(String brand, String model, int yearOfManufacture, String color, double price, long registrationNumber) {
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idNum=" + idNum +
                ", brand=" + brand + '\'' +
                ", model='" + model +
                ", yearOfManufacture=" + yearOfManufacture + '\'' +
                ", color='" + color +
                ", price=" + price + '\'' +
                ", registrationNumber='" + registrationNumber +
                '}';
    }
}


