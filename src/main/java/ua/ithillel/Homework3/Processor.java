package Homework3;

import java.util.*;

class Processor {
    private static ArrayList<Car> carList = new ArrayList<>();

    Processor() {
        carList = generateCarArrayList();
    }

    Processor(ArrayList<Car> carList) {
        this.carList = carList;
    }

    static ArrayList<Car> generateCarArrayList() {
        ArrayList<Car> carList = new ArrayList<>();

        carList.add(new Car("Nissan", "350z", 2014, "Orang", 810000.00, 1));
        carList.add(new Car("BMW", "Z4", 2011, "Blue", 436000.00, 2));
        carList.add(new Car("MAZDA", "RX-8", 2015, "Black", 1200000.00, 3));
        carList.add(new Car("Nissan", "350z", 2014, "Orang", 810000.00, 1));
        carList.add(new Car("BMW", "Z4", 2011, "Blue", 436000.00, 2));
        carList.add(new Car("MAZDA", "RX-8", 2015, "Black", 1200000.00, 3));
        carList.add(new Car("Nissan", "350z", 2014, "Orang", 810000.00, 1));
        carList.add(new Car("BMW", "Z4", 2011, "Blue", 436000.00, 2));
        carList.add(new Car("MAZDA", "RX-8", 2015, "Black", 1200000.00, 3));

        return carList;
    }

    static void printCar(ArrayList<Car> generalSpecificationsList) {
        long regNumValue = 0;

        System.out.println("список автомобилей.");
        for (Car registrationNumberValue : generalSpecificationsList) {
            regNumValue = registrationNumberValue.getRegistrationNumber();
            System.out.println(registrationNumberValue.toString());

        }
    }


    static void getCarsByModel(ArrayList<Car> generalSpecificationsList, String brand) {
        // String brand = "BMW";
        String brandCar = "";

        System.out.println("список автомобилей заданной марки " + brand + ".");
        for (Car brandValue : generalSpecificationsList) {
            brandCar = brandValue.getBrand();
            if (brandCar == brand)
                System.out.println(brandValue.toString());
        }
    }

    static void getCarsByPeriodOfUse(ArrayList<Car> generalSpecificationsList, String model) {
        //String model = "RX-8";
        String modelCar = "";
        int n = 2;
        int timeNow = 2019;
        int exploitationYears = 0;

        System.out.println("список автомобилей заданной модели , которые эксплуатируются больше " + n + " лет.");
        for (Car modelValue : generalSpecificationsList) {
            modelCar = modelValue.getModel();
            for (Car yearOfManufactureValue : generalSpecificationsList)
                exploitationYears = timeNow - yearOfManufactureValue.getYearOfManufacture();
            if ((modelCar == model) && (exploitationYears > n))
                System.out.println(modelValue.toString());
        }
    }

    static void getCarsByPriceMoreThan(ArrayList<Car> generalSpecificationsList, double minPrice, int setYear) {
        int yearValue = 0;

        double priceMaxValue = 0;

        System.out.println("список автомобилей " + setYear + " года выпуска, цена которых больше " + minPrice + ".");
        for (Car yearOfManufactureValue : generalSpecificationsList) {
            yearValue = yearOfManufactureValue.getYearOfManufacture();
            for (Car priceValue : generalSpecificationsList)
                priceMaxValue = priceValue.getPrice();
            if ((yearValue == setYear) && (priceMaxValue > minPrice))
                System.out.println(yearOfManufactureValue.toString());
        }
    }

    static void getCarsByModel(String brand) {
        String brandCar = "";

        if (!carList.isEmpty()) {
            System.out.println("прошла проверка: списки автомобилей не пустые!");
            System.out.println("список автомобилей заданной марки " + brand + ".");
            for (Car brandValue : Processor.carList) {
                brandCar = brandValue.getBrand();
                if (brandCar == brand)
                    System.out.println(brandValue.toString());
            }
        } else
            System.out.println("список автомобилей пуст!");
    }

    void getCarsByPeriodOfUse(String model) {
        String modelCar = "";
        int n = 2;
        int timeNow = 2019;
        int exploitationYears = 0;

        if (!carList.isEmpty()) {
            System.out.println("прошла проверка: списки автомобилей не пустые!");
            System.out.println("список автомобилей заданной модели, " + model + " которые эксплуатируются больше " + n + " лет.");
            for (Car modelValue : Processor.carList) {
                modelCar = modelValue.getModel();
                for (Car yearOfManufactureValue : Processor.carList)
                    exploitationYears = timeNow - yearOfManufactureValue.getYearOfManufacture();
                if ((modelCar == model) && (exploitationYears > n))
                    System.out.println(modelValue.toString());
            }
        } else
            System.out.println("список автомобилей пуст!");
    }

    void getCarsByPriceMoreThan(double minPrice, int setYear) {
        int yearValue = 0;
        double priceMaxValue = 0;

        if (!carList.isEmpty()) {
            System.out.println("прошла проверка: списки автомобилей не пустые!");
            System.out.println("список автомобилей " + setYear + " года выпуска, цена которых больше " + minPrice + ".");
            for (Car yearOfManufactureValue : Processor.carList) {
                yearValue = yearOfManufactureValue.getYearOfManufacture();
                for (Car priceValue : Processor.carList)
                    priceMaxValue = priceValue.getPrice();
                if ((yearValue == setYear) && (priceMaxValue > minPrice))
                    System.out.println(yearOfManufactureValue.toString());
            }
        } else
            System.out.println("список автомобилей пуст!");
    }
}

