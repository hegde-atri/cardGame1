package cardgame1;

import java.util.*;

public class CardGame1 {

    private static boolean game = true;
    private static boolean userChoice;
    private static Random randint = new Random();

    public static int cardNumber() {
        return randint.nextInt(14);

    }

    public static String cardSuit(int cardNumber) {
        if (cardNumber > 13) {
            return null;
        } else {
            int a = randint.nextInt(4);
            switch (a) {
                case (0):
                    //Spades
                    return "\u2660";
                case (1):
                    //hearts
                    return "b";
                case (2):
                    //clubs
                    return "c";
                case (3):
                    return "d";
                default:
                    return ("error");
            }

        }
    }

    public static void userChoose() {
        Scanner input = new Scanner(System.in);

        //Scans user Input and changes public variable userChoice to true or false, this is not ideal but works for now since there are only 2 outputs
        System.out.print("Higher or lower (type 1 or 2)\t");
        try {
            int x = Integer.parseInt(input.nextLine());
            switch (x) {
                case (1):
                    userChoice = true;
                    break;
                case (2):
                    userChoice = false;
                    break;
                default:
                    System.out.println("Error: ");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public static void saveScore() {

    }

    public static void runGame() {

        String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "Joker"};
        int currentCard, oldCard, score;
        currentCard = cardNumber();
        score = 0;
        String card = cards[cardNumber()];
        System.out.println(card);

        while (game = true) {
            
            userChoose();
            oldCard = currentCard;
            currentCard = cardNumber();

            if ((currentCard > oldCard) && userChoice == true) {
                score += 1;
                System.out.println(cards[currentCard]);
                
            } else if ((currentCard < oldCard) && userChoice == false) {
                score = +1;
                System.out.println(cards[currentCard]);
                
            } else {
                
                System.out.println("You guessed wrong, the next card was " + cards[currentCard]);
                System.out.println("Your final score was- " + score);
                Scanner input = new Scanner(System.in);
                System.out.print("Do you want to save your score (type y/n)");
                char isUserSave = input.nextLine().charAt(0);
                
                if (isUserSave == 'a') {
                    saveScore();
                    game = false;
                    break;
                } else {
                    System.out.println("GG");
                    game = false;
                    break;
                }
            }

        }

    }

    public static void main(String[] args) {
        runGame();

    }

}
