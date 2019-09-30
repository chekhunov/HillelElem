package ua.ithillel.hw11.taxiPark;

import ua.ithillel.hw11.file.FileTransportStorage;
import ua.ithillel.hw11.interfaces.ITaxiPark;
import ua.ithillel.hw11.storage.TransportStorage;
import ua.ithillel.hw11.transport.Transport;

import java.util.ArrayList;
import java.util.Collections;

public class ThisTaxiPark implements ITaxiPark {

    private static ArrayList<Transport> transportList = new ArrayList<>();

    public ThisTaxiPark(ArrayList<Transport> transportList) {
        this.transportList = transportList;
    }

    public static ArrayList<Transport> generateTransports() {
        TransportStorage storage =
                new FileTransportStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw11/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw11/output.txt");
        return storage.readTransports();
    }

    public ArrayList<Transport> findTransportSpeed(ArrayList<Transport> transport, int minSpeed, int maxSpeed) {
        ArrayList<Transport> temp = new ArrayList<>();
        for (Transport transport1 : transport) {
            if (transport1.getSpeed() >= minSpeed && transport1.getSpeed() <= maxSpeed) {
                temp.add(transport1);
            }
        }
        return temp;
    }

    @Override
    public int valuePark(ArrayList<Transport> transportArray) {
        int sum = 0;
        for (Transport temp : transportArray) {
            sum += temp.getPrice();
        }
        return sum;
    }

    @Override
    public ArrayList<Transport> sortTransportFuel(ArrayList<Transport> transportArray) {
        ArrayList<Transport> temp = new ArrayList<>();
        for (Transport transport1 : transportArray) {
            temp.add(transport1);
            Collections.sort(temp);
        }
        return temp;
    }

    @Override
    public ArrayList<Transport> getTransports() {
        return transportList;
    }
}

