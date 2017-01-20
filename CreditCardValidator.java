package ca.uwo.eng.se2205b;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Long;


/**
 * Problem #3: Validates a Credit Card
 */
public class CreditCardValidator {

    /**
     * Compute if the number is a valid Credit Card Number.
     *
     * @param number Credit Card number to validate.
     * @return Non-{@code null} enum of the type of credit card.
     */
    public enum CardType {
        VISA, MASTERCARD, AMEX, DISVOVER
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the credit card number: ");
        if(isValid(in.nextLong()))
            System.out.println("Credi card number is valid!");
        else
            System.out.println("Credit card number is invalid!");
        in.close();
    }

    private static boolean isValid(long number){
        //declare and initialize: the sum of odd digit; the sum of even digits and the final result to be returned
        int sumEven=0;
        int sumOdd=0;
        boolean result=false;
        //first check the size 13-16
        if((getSize(number)>=13) && (getSize(number)<=16))
            //then check the prefix aka card type is valid
            if(getPrefix(number,4)|| getPrefix(number,5) || getPrefix(number,6) || getPrefix(number,36))
            //now check the sum
            {
                
                sumEven=sumOfEvenDigit(number);
                sumOdd=sumOfOddDigit(number);

            }



    }
    //get prefix to check the card type
    private static boolean getPrefix(long number, int d){
        int length=new StringBuilder(Integer.toString(d)).length();
        String numToString = Long.toString(number);
        String dToString = Integer.toString(d);
        for(int i = 0; i<length;i++)
            if(numToString.charAt(i) == dToString.charAt(i))
                return false;
        return true;
    }
    //get size function
    private static int getSize(long number){
       return Long.toString(number).length();
    }
     //calculate the sum od even digit
    private static int sumOfEvenDigit(long number){

    }
    //calculate the sum of odd digit
    private static int sumOfOddDigit(long number){
        
    }

}
