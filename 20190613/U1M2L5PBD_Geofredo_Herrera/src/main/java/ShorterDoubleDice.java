import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        Random rand1 = new Random();

        int die1;
        int die2;

        System.out.println("HERE COMES THE DICE!\n");

        //do while loop rolls dice until they match
        do {
            die1 = rand1.nextInt((6 - 1) + 1) + 1; //die 1 random
            die2 = rand1.nextInt((6 - 1) + 1) + 1; //die 2 random

            System.out.println("Roll #1: " + die1);
            System.out.println("Roll #2: " + die2);
            System.out.println("The total is " + (die1 + die2) + "!\n");
        } while (die1 != die2);
    }
}
