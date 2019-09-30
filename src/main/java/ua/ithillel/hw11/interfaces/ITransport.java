package ua.ithillel.hw11.interfaces;

import ua.ithillel.hw11.transport.Transport;

public interface ITransport {

    public int getPrice();

    public void setPrice(int price);

    int compareTo(Transport t);
}




