package ua.ithillel.hw15.interfaces;

import ua.ithillel.hw15.transport.Transport;

public interface ITransport {

    public int getPrice();

    public void setPrice(int price);

    int compareTo(Transport t);
}




