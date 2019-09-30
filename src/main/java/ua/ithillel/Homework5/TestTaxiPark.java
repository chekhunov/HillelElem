package Homework5;


import java.util.Arrays;

public class TestTaxiPark {

    public static Transport[] generateTransports() {

        Bulldozer catBulldozer = new Bulldozer("BGL D3K2 XL", 80, 30, 2860000, 7, 2);
        Bulldozer petroNickBulldozer = new Bulldozer("LHJ A8K2 L", 70, 28, 2500000, 5, 1);

        Tractor catTractor = new Tractor("GMU F812I", 60, 40, 2300000, 5, 1);
        Tractor petroNickTractor = new Tractor("KMO F1342I", 70, 50, 2000000, 3, 2);

        Cargo renaultCargo = new Cargo("Renault-Master", 25, 140, 450000, 6, 1);
        Cargo mercedesCargo = new Cargo(" Mercedes-Benz", 22, 160, 600000, 4, 1);

        Passenger daewooPassenger = new Passenger("Daewoo-sens", 12, 90, 180000, 4, 4);
        Passenger daewooPassenger1 = new Passenger("Daewoo-lanos", 12, 90, 180000, 4, 4);

        Transport[] allPark = new Transport[]{catBulldozer, petroNickBulldozer, catTractor,
                petroNickTractor, renaultCargo, mercedesCargo, daewooPassenger, daewooPassenger1};

        return allPark;
    }

    public static void main(String[] args) {

        TaxiPark taxiPark = new TaxiPark();
//        Passenger passenger = new Passenger("BGL D3K2 XL", 80, 30, 2860000, 7, 2);
//        passenger.setCategory("b");
//        passenger.go();


//    System.out.println(Arrays.toString(taxiPark.findTransportSpeed(generateTransports(), 40, 100)));
//    System.out.println(taxiPark.valuePark(generateTransports()));
//    System.out.println(Arrays.toString(taxiPark.sortbubbleTransportFuel(generateTransports())));
    }
}