package ua.ithillel.hw15.file;

import ua.ithillel.hw15.storage.TransportStorage;
import ua.ithillel.hw15.transport.Transport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileTransportStorage implements TransportStorage {

    private String inputFile;
    private String outputFile;

    public FileTransportStorage(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public ArrayList<Transport> readTransports() {

        FileInputStream fis = null;
        byte[] readBytes = new byte[0];
        try {
            fis = new FileInputStream(inputFile);
            readBytes = new byte[fis.available()];
            fis.read(readBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file = new String(readBytes);
        String[] array = file.split(";");

        Transport[] transportArray = new Transport[array.length];
        for (int i = 0; i < array.length; i++) {
            transportArray[i] = convertStringOrObject(array[i]);

        }
        return new ArrayList<Transport>(Arrays.asList(transportArray));
    }

    private Transport convertStringOrObject(String transport) {

        String[] parametrs = transport.trim().split(",");
        Transport transport1 =
                new Transport(parametrs[0], Integer.parseInt(parametrs[1]),
                        Integer.parseInt(parametrs[2]), Integer.parseInt(parametrs[3]));
        return transport1;
    }

    @Override
    public void writeTransports(String transportsToWrite) {
        FileOutputStream fos = null;
        byte[] readBytes1 = new byte[transportsToWrite.length()];
        try {
            fos = new FileOutputStream(new File(outputFile));
            readBytes1 = transportsToWrite.getBytes();
            fos.write(readBytes1, 0, readBytes1.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

}
