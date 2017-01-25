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
    public static void main(String[] args) {
        //Not sure if this line is correct or not
        Iterator<Integer> primeIter = new PalindromeIterator();

        while (true) {
            if (primeIter.hasNext()) {
                System.out.print(primeIter.next() + "\t");
            }
            else {
                break;
            }
        }
    }

    //iterator
    public static class PalindromeIterator implements Iterator<Integer> {

        int size = 100000;
        boolean[] isPrime = new boolean[size];

        int index = 1;

        int numPrimesPrinted = 0;

        //constructor to assign all the value to true
        public PalindromeIterator(){
            isPrime[0] = false;//0+1 is not prime
            //initial all the value true
            for (int i = 1; i < size; i++) {
                isPrime[i] = true;
            }
        }

        //find if the number is palindrome
        private boolean checkPalin(int num) {
            //declare and initialize variables
            int result = 0;
            int number = num;
            //reverse the num
            while (num != 0) {
                int lastDigit = num % 10;
                result = result * 10 + lastDigit;
                num /= 10;
            }

            if (number == result)
                return true;
            else
                return false;
        }

        //check if the number is prime
        private boolean checkPrime(int num) {
            for (int divisor = 2; 2* divisor <= num; divisor ++) { //just to check the odds
                if (num % divisor == 0)
                return false;
            }
            return true;
        }

        //override functions
        @Override
        public boolean hasNext() {
            while (index < size) {
                index++;
                if (checkPalin(index) && checkPrime(index)) {
                    numPrimesPrinted++;
                    return true;
                }

            }
           return false;

        }

        @Override
        public Integer next() {
            if(numPrimesPrinted % 10 ==0){
                System.out.println();
            }
            return index;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }



    }

}


