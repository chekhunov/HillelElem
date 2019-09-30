package ua.ithillel.hw9.interfaces;

import ua.ithillel.hw9.transport.Transport;

public interface ITransport {

    public int getPrice();

    public void setPrice(int price);

    int compareTo(Transport t);
}




