package ua.ithillel.hw8;

import java.util.Arrays;

public class PrimeNumbersStorage {
    private int[] numbers={};

   synchronized void  addNumbers(int[] numbersToAdd){
//...необходимо реализовать скопировать из numbersToAdd в numbers массив
       System.arraycopy(numbersToAdd, 0, numbers, 0, numbersToAdd.length);
   }
   public  int[] getNumbers(){
       return numbers;
   }
   public void setNumbers(int[] numbers){
       this.numbers=numbers;
  }
}
