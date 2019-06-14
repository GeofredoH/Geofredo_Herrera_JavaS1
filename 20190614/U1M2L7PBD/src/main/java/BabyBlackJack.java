import java.util.Random;

public class BabyBlackJack {
    public static void main(String[] args) {

        Random rand = new Random();
        int player1 = rand.nextInt(10) + 1;
        int player2 = rand.nextInt(10) + 1;
        int player1Total = player1 + player2;

        int dealer1 = rand.nextInt(10) + 1;
        int dealer2 = rand.nextInt(10) + 1;
        int dealerTotal = dealer1 + dealer2;

        System.out.println("You drew a " + player1 + " and " + player2);
        System.out.println("Your total is " + player1Total);

        System.out.println("\nThe dealer drew a " + dealer1 + " and " + dealer2);
        System.out.println("Dealer's total is " + dealerTotal);

        if (player1Total > dealerTotal){
            System.out.println("\nYOU WIN!");
        } else {
            System.out.println("\nYOU LOSE!");
        }
    }
}
