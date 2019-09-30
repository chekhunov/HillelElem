package ua.ithillel.hw9.interfaces;


import ua.ithillel.hw9.transport.Transport;

public interface ITaxiPark {

    public int valuePark(Transport[] transportArray);
    public Transport[] sortbubbleTransportFuel(Transport[] transportArray);
    Transport[] getTransports();
}




