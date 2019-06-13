import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        System.out.println("I will add up the numbers you give me.");

        int total = 0;

        System.out.print("Number: ");
        userInput = myScanner.nextInt();

        //zero is the sentinel value to end program
        while (userInput != 0) {
            System.out.println("The total so far is " + (total += userInput));
            System.out.print("Number: ");
            userInput = myScanner.nextInt();
        }

        System.out.println("\nThe total is " + (total += userInput));

    }
}
