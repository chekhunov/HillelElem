package Homework6.taxiPark;

import Homework6.TestTaxiPark;
import Homework6.interfaces.ITaxiPark;
import Homework6.transport.Transport;

public class ThisTaxiPark implements ITaxiPark {

    private Transport[] transports;

    public void getTaxiPark() {
        transports = TestTaxiPark.generateTransports();
    }

    @Override
    public int valuePark(Transport[] transportArray) {
        int sum = 0;
        for (Transport temp : transportArray) {
            sum += temp.getPrice();
        }
        return sum;
    }

    @Override
    public Transport[] sortbubbleTransportFuel(Transport[] transportArray) {
        for (int i = 0; i < transportArray.length; i++) {
            for (int j = i + 1; j < transportArray.length; j++) {
                if (transportArray[j].getConsumptionFuel() < transportArray[i].getConsumptionFuel()) {
                    Transport temp = transportArray[j];
                    transportArray[j] = transportArray[i];
                    transportArray[i] = temp;
                }
            }
        }
        return transportArray;
    }

    public Transport[] findTransportSpeed(Transport[] transport, int minSpeed, int maxSpeed) {

        Transport[] tempArray = new Transport[1];
        for (Transport transport1 : getTransports()) {
            if (transport1.getSpeed() >= minSpeed && transport1.getSpeed() <= maxSpeed) {
                tempArray = extendCarsArrayByNewCar(transport1, tempArray);
            }
        }
        return tempArray;
    }

    private Transport[] extendCarsArrayByNewCar(Transport transportToAdd, Transport[] transports) {
        if (transports.length == 0) {
            return new Transport[]{transportToAdd};
        } else {
            Transport[] newCarsArr = new Transport[transports.length + 1];

            for (int i = 0; i < transports.length; i++) {
                newCarsArr[i] = transports[i];
            }
            newCarsArr[transports.length] = transportToAdd;
            return newCarsArr;
        }
    }

    public Transport[] getTransports() {
        return transports;
    }

    public void setTransports(Transport[] transports) {
        this.transports = transports;
    }
}
