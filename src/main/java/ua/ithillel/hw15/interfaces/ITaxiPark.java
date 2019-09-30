package ua.ithillel.hw15.interfaces;

import ua.ithillel.hw15.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public interface ITaxiPark {

    public List<Transport> findTransportSpeed(ArrayList<Transport> transport, int minSpeed, int maxSpeed);
    public int valuePark(ArrayList<Transport> transportArray);
    public void transportFuelSort(ArrayList<Transport> transportArray);
    ArrayList<Transport> getTransports();
}




