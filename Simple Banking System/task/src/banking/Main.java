package banking;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static String newPin() {
        String pin;
        int lower = 1000;
        int upper = 9999;
        pin = Integer.toString(random.nextInt(upper - lower + 1) + lower);

        return pin;
    }

    public static Map<String, Card> cards = new HashMap<>();

    static private boolean exitMainMenu = false;

    static public void tryLogin() {

        System.out.println("Enter your card number:");
        String cardNumberCheck = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String pinCheck = scanner.nextLine();

        Card tryCard = cards.get(pinCheck);
        if (tryCard != null)
            if (tryCard.getCardNumber().equals(cardNumberCheck)) {
                System.out.println("You have successfully logged in!");
                accountMenu(tryCard);
            } else {
                System.out.println("Wrong card number or PIN!");
            }
    }

    static void accountMenu(Card workCard) {

        String menuChoice;
        do {

            System.out.println("1. Balance \n2. Log out \n0. Exit");

            menuChoice = scanner.nextLine();

            switch (menuChoice) {

                case "1":
                    System.out.println("Balance: " + workCard.getBalance());
                    break;
                case "2":
                    System.out.println("You have successfully logged out!");
                    menuChoice = "0";
                    break;
                case "0":
                    System.out.println("Bye!");
                    exitMainMenu = true;
                default:
                    break;
            }
        } while (!menuChoice.equals("0"));
    }

    static public void mainMenu() {

        String menuChoice;

        do {

            System.out.println("1. Create an account \n2. Log into account \n0. Exit");

            menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "0":
                    exitMainMenu = true;
                    break;
                case "1":

                    Card newCard = new Card();

                    String tryPin;
                    do {
                        tryPin = newPin();
                    } while ((cards.get(tryPin)) != null);

                    newCard.setPin(tryPin);
                    cards.put(newCard.getPin(), newCard);

                    System.out.println("Your card has been created");
                    System.out.println("Your card number:");
                    System.out.println(newCard.getCardNumber());
                    System.out.println("Your card PIN:");
                    System.out.println(newCard.getPin());
                    break;
                case "2":
                    tryLogin();
                    break;
            }
        } while (!exitMainMenu);
    }


    public static void main(String[] args) {

        mainMenu();

    }


}
