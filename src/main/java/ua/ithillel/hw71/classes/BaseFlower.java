package ua.ithillel.hw71.classes;

public class BaseFlower {
    private String name;
    private float price;

    public BaseFlower(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BaseFlower{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
