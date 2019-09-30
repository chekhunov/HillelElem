package ua.ithillel.hw11.interfaces;

import ua.ithillel.hw11.transport.Transport;

import java.util.ArrayList;

public interface ITaxiPark {

    public int valuePark(ArrayList<Transport> transportArray);
    public ArrayList<Transport> sortTransportFuel(ArrayList<Transport> transportArray);
    ArrayList<Transport> getTransports();
}




