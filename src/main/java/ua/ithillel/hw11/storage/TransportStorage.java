package ua.ithillel.hw11.storage;

import ua.ithillel.hw11.transport.Transport;

import java.util.ArrayList;

public interface TransportStorage {

    ArrayList<Transport> readTransports();
    void writeTransports(String transportsToWrite);
}
