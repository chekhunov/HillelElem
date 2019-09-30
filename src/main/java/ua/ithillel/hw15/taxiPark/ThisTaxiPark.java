package ua.ithillel.hw15.taxiPark;

import ua.ithillel.hw15.file.FileTransportStorage;
import ua.ithillel.hw15.interfaces.ITaxiPark;
import ua.ithillel.hw15.storage.TransportStorage;
import ua.ithillel.hw15.transport.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThisTaxiPark implements ITaxiPark {

    private static ArrayList<Transport> transportList = new ArrayList<>();

    public ThisTaxiPark(ArrayList<Transport> transportList) {
        this.transportList = transportList;
    }

    public static ArrayList<Transport> generateTransports() {
        TransportStorage storage =
                new FileTransportStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw15/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw15/output.txt");
        return storage.readTransports();
    }

    @Override
    public List<Transport> findTransportSpeed(ArrayList<Transport> transport, int minSpeed, int maxSpeed) {

        return transport.stream()
                .filter(p -> p.getSpeed() >= minSpeed && p.getSpeed() <= maxSpeed)
                .collect(Collectors.toList());
    }

    @Override
    public int valuePark(ArrayList<Transport> transportArray) {

        return transportArray.stream().map(Transport::getPrice).reduce(0, Integer::sum);
    }

    @Override
    public void transportFuelSort(ArrayList<Transport> transportArray) {
        transportArray.stream()
                .filter(p -> p.getConsumptionFuel() < 100)
                .sorted();
    }

    @Override
    public ArrayList<Transport> getTransports() {
        return transportList;
    }
}

