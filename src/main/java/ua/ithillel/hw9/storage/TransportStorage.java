package ua.ithillel.hw9.storage;

import ua.ithillel.hw9.taxiPark.ThisTaxiPark;
import ua.ithillel.hw9.transport.Transport;

public interface TransportStorage {

    Transport[] readTransports();
    void writeTransports(String transportsToWrite);
}
