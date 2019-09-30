package ua.ithillel.hw11;

import ua.ithillel.hw11.file.FileTransportStorage;
import ua.ithillel.hw11.interfaces.ITaxiPark;
import ua.ithillel.hw11.storage.TransportStorage;
import ua.ithillel.hw11.taxiPark.ThisTaxiPark;

import java.io.IOException;

public class TestTaxiPark {

    public static void main(String[] args) throws IOException {

        ITaxiPark taxiPark = new ThisTaxiPark(ThisTaxiPark.generateTransports());

        System.out.println(taxiPark.getTransports());
        System.out.println(((ThisTaxiPark) taxiPark).findTransportSpeed(taxiPark.getTransports(),
                90,90));
        System.out.println(taxiPark.valuePark(taxiPark.getTransports()));
        System.out.println(taxiPark.sortTransportFuel(taxiPark.getTransports()));

        TransportStorage storage =
                new FileTransportStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw11/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw11/output.txt");
        storage.writeTransports(String.valueOf(storage.readTransports()));

    }
}

