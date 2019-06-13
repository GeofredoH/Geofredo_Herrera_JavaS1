import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        System.out.println("SQUARE ROOT!");
        Scanner myScanner = new Scanner(System.in);
        int userInput;

        System.out.print("Enter a number: ");
        userInput = myScanner.nextInt();

        //checks user input to see if it is negative
        while (userInput < 0) {
            System.out.print("You can't take the square root of a negative number, silly." +
                    "\nTry Again: ");
            userInput = myScanner.nextInt();
        }

        System.out.println("The square root of " + userInput + " is " + Math.sqrt(userInput));
    }
}
