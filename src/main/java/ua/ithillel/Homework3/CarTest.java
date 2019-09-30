package Homework3;

import java.util.ArrayList;

public class CarTest {
    public static void main(String[] args) {

        ArrayList<Car> carList = Processor.generateCarArrayList();
        Processor processor = new Processor(carList);

        Processor.printCar(carList);

        processor.getCarsByModel("BMW");
        Processor.getCarsByModel(carList, "BMW");

        Processor.getCarsByPeriodOfUse(carList, "RX-8");
        processor.getCarsByPeriodOfUse("RX-8");

        Processor.getCarsByPriceMoreThan(carList, 600000.00, 2014);
        processor.getCarsByPriceMoreThan(600000.00, 2014);
    }
}
