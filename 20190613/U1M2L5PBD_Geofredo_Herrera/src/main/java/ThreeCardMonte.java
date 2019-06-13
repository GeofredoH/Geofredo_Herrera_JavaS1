import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        Random rand1 = new Random();
        int secretChoice = rand1.nextInt((3 - 1) + 1) + 1;

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.");
        System.out.println("\nWhich one is the ace?\n" +
                "\n" +
                "\t##  ##  ##\n" +
                "\t##  ##  ##\n" +
                "\t1   2   3");
        userInput = myScanner.nextInt();

        //compares user guess with random number and reveals if guess is correct
        if (userInput == secretChoice) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
            if (secretChoice == 1) {
                System.out.println("\tAA  ##  ##\n" +
                        "\tAA  ##  ##\n" +
                        "\t1   2   3");
            } else if (secretChoice == 2) {
                System.out.println("\t##  AA  ##\n" +
                        "\t##  AA  ##\n" +
                        "\t1   2   3");
            } else {
                System.out.println("\t##  ##  AA\n" +
                        "\t##  ##  AA\n" +
                        "\t1   2   3");
            }
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + secretChoice + ".");
            if (secretChoice == 1) {
                System.out.println("\tAA  ##  ##\n" +
                        "\tAA  ##  ##\n" +
                        "\t1   2   3");
            } else if (secretChoice == 2) {
                System.out.println("\t##  AA  ##\n" +
                        "\t##  AA  ##\n" +
                        "\t1   2   3");
            } else {
                System.out.println("\t##  ##  AA\n" +
                        "\t##  ##  AA\n" +
                        "\t1   2   3");
            }
        }
    }
}
