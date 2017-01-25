package ca.uwo.eng.se2205b;

import java.util.Scanner;

public class CreditCardValidator {
    public CreditCardValidator() {
    }

    public static void main(String[] args) {
        System.out.println("Please enter the credit card number: ");
        Scanner in = new Scanner(System.in);
        long number = in.nextLong();
        if(isValid(number)) {
            System.out.println("Credit card number is valid!");
            cardType(number);
        } else {
            System.out.println("Credit card number is invalid!");
        }

        in.close();
    }

    private static boolean isValid(long number) {
        boolean sumEven = false;
        boolean sumOdd = false;
        boolean result = false;
        if(getSize(number) >= 13 && getSize(number) <= 16 && (getPrefix(number, 4) || getPrefix(number, 5) || getPrefix(number, 6) || getPrefix(number, 36))) {
            int sumEven1 = sumOfEvenDigit(number);
            int sumOdd1 = sumOfOddDigit(number);
            result = (sumEven1 + sumOdd1) % 10 == 0;
        }

        return result;
    }

    private static void cardType(long number) {
        CreditCardValidator.CardType card = CreditCardValidator.CardType.AMEX;
        String cardNumber = Long.toString(number);
        if(cardNumber.charAt(0) == '4') {
            System.out.println(CreditCardValidator.CardType.VISA);
        } else if(cardNumber.charAt(0) == '5') {
            System.out.println(CreditCardValidator.CardType.MASTERCARD);
        } else if(cardNumber.charAt(0) == '6') {
            System.out.println(CardType.DISVOVER);
        } else if(cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '4') {
            System.out.println(CreditCardValidator.CardType.AMEX);
        } else {
            System.out.println("no card type found");
        }

    }

    private static boolean getPrefix(long number, int d) {
        int length = (new StringBuilder(Integer.toString(d))).length();
        String numToString = Long.toString(number);
        String dToString = Integer.toString(d);

        for(int i = 0; i < length; ++i) {
            if(numToString.charAt(i) == dToString.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static int getSize(long number) {
        return Long.toString(number).length();
    }

    private static int sumOfEvenDigit(long number) {
        int sum = 0;
        long doubleDigit = 0L;
        long[] digit = new long[getSize(number)];

        int j;
        for(j = 0; j < digit.length; ++j) {
            digit[j] = number % 10L;
            number /= 10L;
        }

        for(j = 1; j < digit.length; j += 2) {
            doubleDigit = digit[j] * 2L;
            if(doubleDigit > 9L) {
                doubleDigit = doubleDigit % 10L + doubleDigit / 10L;
            }

            sum = (int)((long)sum + doubleDigit);
        }

        return sum;
    }

    private static int sumOfOddDigit(long number) {
        int sum = 0;
        long[] digit = new long[getSize(number)];

        int j;
        for(j = 0; j < digit.length; ++j) {
            digit[j] = number % 10L;
            number /= 10L;
        }

        for(j = 0; j < digit.length; j += 2) {
            sum = (int)((long)sum + digit[j]);
        }

        return sum;
    }

    public static enum CardType {
        VISA,
        MASTERCARD,
        AMEX,
        DISVOVER;

        private CardType() {
        }
    }
}
