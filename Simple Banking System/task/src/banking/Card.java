package banking;

import java.util.Random;

public class Card {
     private String cardNumber;
     private String pin;
     private double balance;
     static private Random random = new Random();

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
        setCardNumber(newCardNumber());
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
