package ca.uwo.eng.se2205b;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Problem #2: Finds prime numbers and checks if they are palindromes.
 */
public class PalindromicPrime {

    /**
     * Creates an iterator that returns prime palindrome numbers.
     *
     * @return Non-{@code null} iterator to get palindrome prime numbers.
     */
    public static void main(String[] args){
        int counter = 0;
        int number = 2;//initialize variables
        String result= "";//the number to be printed out

        while(counter <= 1000000){
          if(findPrime(number) && findPalin(number)) {//ask if the number is prime or palindrome

    }
}
//iterator
        //public Iterator<Integer> palindromeIterator() {
        // private static class InnerClass implements Interator<Integer>{

        //  public boolean hasNext(){
        //    return false;
        //   }

        //   public int next(){
        //      return 0;}
        //    public void remove(){
        //     throw new UnsupportedOperationException("");
        //    }
        //  }
        //  return null;

//find if the number is prime
    private boolean findPrime(int num){
        if(num%2 == 0)//to check if the number is even, if it is(except 2)then not prime
            return false;
        for(int divisor=3; divisor*divisor<=num; divisor+=2){//just to check the odds
                if(num%divisor == 0)
                    return false;
            }
            return true;
        }
    //find if the number is palindrome
    private boolean findPalin(int num){
          //declare and initialize variables
        int result = 0;
        int number = num;
        //reverse the num
        while(num != 0){
            int lastDigit = num%10;
            result=result*10+lastDigit;
            num/=10;
        }
        if(number == result)
            return true;
        }
        return false;
}

}
