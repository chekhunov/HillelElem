package ua.ithillel.hw9.transport;

import java.util.Comparator;

public class TransportConsumptionFuelComparator implements Comparator<Transport> {
    @Override
    public int compare(Transport o1, Transport o2) {
        if (o1.getConsumptionFuel() > o2.getConsumptionFuel())
            return 1;
        else if (o1.getConsumptionFuel() < o2.getConsumptionFuel())
            return -1;
        else
            return 0;
    }
}
