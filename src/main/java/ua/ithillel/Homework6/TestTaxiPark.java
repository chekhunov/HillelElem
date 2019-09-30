package Homework6;


import Homework6.interfaces.ITaxiPark;
import Homework6.taxiPark.ThisTaxiPark;
import Homework6.transport.Cargo;
import Homework6.transport.Passenger;
import Homework6.transport.Transport;

import java.util.Arrays;

public class TestTaxiPark {

    public static Transport[] generateTransports() {

        Cargo renaultCargo = new Cargo( "Renault-Master", 25, 140, 450000,1000);
        Cargo mercedesCargo = new Cargo(" Mercedes-Benz", 22, 160, 600000,500);

        Passenger daewooPassenger = new Passenger("Daewoo-sens", 12, 90, 180000,4);
        Passenger daewooPassenger1 = new Passenger( "Daewoo-lanos", 12, 90, 360000,4);

        Transport[] allPark = new Transport[]{renaultCargo, mercedesCargo, daewooPassenger, daewooPassenger1};

        return allPark;
    }

    public static void main(String[] args) {

        Transport transportPrice = new Passenger("Renault-Master", 25, 140, 450000,1000);
        System.out.println(transportPrice.getPrice());

        ITaxiPark taxiPark = new ThisTaxiPark();
        System.out.println(Arrays.toString(taxiPark.sortbubbleTransportFuel(generateTransports())));

    }
}