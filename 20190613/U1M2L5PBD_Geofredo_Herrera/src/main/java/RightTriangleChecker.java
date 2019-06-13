import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int side1;
        int side2;
        int side3;

        System.out.println("Enter three integers");
        System.out.print("Side 1: ");
        side1 = myScanner.nextInt();

        System.out.print("Side 2: ");
        side2 = myScanner.nextInt();

        //checks user input is entered in ascending order
        while (side2 < side1) {
            System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            System.out.println("Side 2: ");
            side2 = myScanner.nextInt();
        }

        System.out.print("Side 3: ");
        side3 = myScanner.nextInt();

        //checks user input is entered in ascending order
        while (side3 < side2) {
            System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
            System.out.println("Side 3: ");
            side3 = myScanner.nextInt();
        }

        System.out.println("\nYour three sides are " + side1 + " " + side2 + " " + side3);

        //checks right triangle math
        if (Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(side3, 2)) {
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        } else {
            System.out.println("NO!  These sides do not make a right triangle!");
        }
    }
}
