package ua.ithillel.hw9;

import ua.ithillel.hw7.Test;
import ua.ithillel.hw9.interfaces.ITaxiPark;
import ua.ithillel.hw9.storage.TransportStorage;
import ua.ithillel.hw9.storage.file.FileTransportStorage;
import ua.ithillel.hw9.taxiPark.ThisTaxiPark;
import ua.ithillel.hw9.transport.Transport;
import ua.ithillel.hw9.transport.TransportConsumptionFuelComparator;

import java.io.IOException;
import java.util.*;

public class TestTaxiPark {

    public static Transport[] generateTransports() {
        TransportStorage storage =
                new FileTransportStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw9/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw9/output.txt");
        return storage.readTransports();
    }

    public static void main(String[] args) throws IOException {

        ITaxiPark taxiPark = new ThisTaxiPark(generateTransports());

        System.out.println(Arrays.toString(taxiPark.getTransports()));
        System.out.println("Список транспорта ");

        TransportStorage storage =
                new FileTransportStorage
                        ("//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw9/input.txt",
                                "//Users//macbookpro//IdeaProjects//Hillel//src//ua//ithillel//hw9/output.txt");

        List<Transport> transportslist = Arrays.asList(taxiPark.getTransports());
        System.out.println("до сортировки Transport");
        System.out.println(transportslist);

        for (Transport transport : transportslist) {
            System.out.printf("%s: %d\n", transport.getName(), transport.getConsumptionFuel());
        }
        transportslist.sort(Comparator.comparingInt(Transport::getConsumptionFuel));

        System.out.println("\nСписок после сортировки Transport:");
        for (Transport transport : transportslist) {
            System.out.printf("%s: %d\n", transport.getName(), transport.getConsumptionFuel());
        }

        Comparator<Transport> tcomp = new TransportConsumptionFuelComparator().thenComparing(new TransportConsumptionFuelComparator());
        TreeSet<Transport> transportTreeSet = new TreeSet(tcomp);
        transportTreeSet.add(new Transport("Zaz", 12));
        transportTreeSet.add(new Transport("Daewoo", 8));
        transportTreeSet.add(new Transport("Lada", 18));
        transportTreeSet.add(new Transport("BMW", 7));

        System.out.println("");
        for (Transport t : transportTreeSet) {
            System.out.println(t.getName() + " " + t.getConsumptionFuel());
        }


        Transport[] trpArr = new Transport[]{
                new Transport("Zaz", 12),
                new Transport("Daewoo", 8),
                new Transport("Lada", 18),
                new Transport("BMW", 7)
        };
        Arrays.sort(trpArr);
        System.out.println("Стандартная сортировка для массива объектов Transport:\n" + Arrays.toString(trpArr));

        Comparator<Transport> cmp = Comparator
                .comparing(Transport::getName)
                .thenComparing(Transport::getConsumptionFuel);

        Arrays.sort(trpArr, cmp::compare);
        System.out.println("Стандартная сортировка для массива объектов Transport по имени и расходу топлива:\n" + Arrays.toString(trpArr));


        Arrays.sort(trpArr, new TransportConsumptionFuelComparator());
        for(Transport i : trpArr) {
            System.out.println("Name: " + i.getName() +
                    " сonsumptionFuel: " + i.getConsumptionFuel());
        }
        System.out.println("Стандартная сортировка для массива объектов Transport по имени и расходу топлива:\n" + Arrays.toString(trpArr));


    }
}

