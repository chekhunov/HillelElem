package ua.ithillel.hw8;

public class PrimeNumbers implements Runnable {
  private int minNumber;
  private int maxNumber;
  private  PrimeNumbersStorage storage;

    public PrimeNumbers(int minNumber, int maxNumber, PrimeNumbersStorage storage) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.storage = storage;
    }

    public PrimeNumbersStorage getStorage() {
        return storage;
    }

    public void setStorage(PrimeNumbersStorage storage) {
        this.storage = storage;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        int[] findedPrimeNumbers = {};
        int[] temp = {};
        boolean prime = true;
        int summ = 0;

        for (int i=getMinNumber(); i<getMaxNumber(); i++){

        for (int k =0; k < findedPrimeNumbers.length; k++) {
            if (findedPrimeNumbers [k] % 2 == 0) {
                summ+= findedPrimeNumbers [k];
                temp[k]=summ;
            }
        }
        }

        //System.out.println("Summ = " + summ);


//...need finded prime numbers for arr

        getStorage().addNumbers(temp);
    }
}
