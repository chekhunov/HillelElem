package ua.ithillel.hw15;

import ua.ithillel.hw15.file.FileTransportStorage;
import ua.ithillel.hw15.interfaces.ITaxiPark;
import ua.ithillel.hw15.storage.TransportStorage;
import ua.ithillel.hw15.taxiPark.ThisTaxiPark;

import java.io.IOException;
import java.util.Arrays;

public class TestTaxiPark {

    public static void main(String[] args) throws IOException {

        ITaxiPark taxiPark = new ThisTaxiPark(ThisTaxiPark.generateTransports());

        System.out.println(taxiPark.getTransports());
        System.out.println("amount of transport " + taxiPark.valuePark(taxiPark.getTransports()));

        System.out.println(((ThisTaxiPark) taxiPark).findTransportSpeed(taxiPark.getTransports(),
                90, 90));
        taxiPark.transportFuelSort(taxiPark.getTransports());

        TransportStorage storage =
                new FileTransportStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw15/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw15/output.txt");
        storage.writeTransports(String.valueOf(storage.readTransports()));
    }
}

