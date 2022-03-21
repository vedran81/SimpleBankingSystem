package banking;

import java.util.Random;

public class Card {
    private String cardNumber;
    private String pin;
    private double balance;
    static private Random random = new Random();


    public static boolean isValidCreditCardNumber(String cardNumber) {
        // int array for processing the cardNumber
        int[] cardIntArray = new int[cardNumber.length()];

        for (int i = 0; i < cardNumber.length(); i++) {
            char c = cardNumber.charAt(i);
            cardIntArray[i] = Integer.parseInt("" + c);
        }

        for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
            int num = cardIntArray[i];
            num = num * 2;  // step 1
            if (num > 9) {
                num = num % 10 + num / 10;  // step 2
            }
            cardIntArray[i] = num;
        }

        int sum = sumDigits(cardIntArray);  // step 3

        System.out.println(sum);

        // step 4
        return sum % 10 == 0;
    }

    private static int sumDigits(int[] cardIntArray) {
        int res = 0;
        for (int i = 0; i < cardIntArray.length; i++) {
            res = res + cardIntArray[i];
        }
        return res;
    }

    static public String newValidCardNumber() {
        String tryCardNum;
        do {
            tryCardNum = newCardNumber();
        } while (!isValidCreditCardNumber(tryCardNum));
        return tryCardNum;
    }

    static public String newCardNumber() {
        String cardNumber;
        String bin = "400000";
        int lowerAccNr = 100000;
        int upperAccNr = 999999;

        int accNr = random.nextInt(upperAccNr - lowerAccNr + 1) + lowerAccNr;
        int lowerChecksum = 1000;
        int upperChecksum = 9999;
        int checksum = random.nextInt(upperChecksum - lowerChecksum + 1) + lowerChecksum;
        cardNumber = bin + accNr + checksum;
        return cardNumber;
    }

    public Card() {
        setCardNumber(newValidCardNumber());
        setBalance(0);
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
