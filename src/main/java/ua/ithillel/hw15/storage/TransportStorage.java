package ua.ithillel.hw15.storage;

import ua.ithillel.hw15.transport.Transport;

import java.util.ArrayList;

public interface TransportStorage {

    ArrayList<Transport> readTransports();
    void writeTransports(String transportsToWrite);
}
