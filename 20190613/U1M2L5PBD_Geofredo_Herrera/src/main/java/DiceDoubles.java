import java.util.Random;

public class DiceDoubles {

    public static void main(String[] args) {
        Random rand1 = new Random();
        int die1 = rand1.nextInt((6 - 1) + 1) + 1; //die 1 random
        int die2 = rand1.nextInt((6 - 1) + 1) + 1; //die 2 random

        System.out.println("HERE COMES THE DICE!\n");

        //looks for a matching pair of dice to end program
        while (die1 != die2) {
            die1 = rand1.nextInt((6 - 1) + 1) + 1; //die 1 random
            die2 = rand1.nextInt((6 - 1) + 1) + 1; //die 2 random

            System.out.println("Roll #1: " + die1);
            System.out.println("Roll #2: " + die2);
            System.out.println("The total is " + (die1 + die2) + "!\n");
        }
    }
}

