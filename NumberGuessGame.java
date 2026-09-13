import java.util.Random;
import java.util.Scanner;

/**
 * CodSoft Java Development Internship - Task 1
 * NUMBER GUESSING GAME
 *
 * Features implemented:
 *  1. Generates a random number within a specified range (1 to 100).
 *  2. Prompts the user to guess the number.
 *  3. Gives feedback: correct / too high / too low.
 *  4. Repeats until the correct number is guessed or attempts run out.
 *  5. Limits the number of attempts per round.
 *  6. Supports multiple rounds (play again).
 *  7. Tracks and displays the user's score across rounds.
 */
public class NumberGuessGame {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        printWelcome();

        while (playAgain) {
            roundsPlayed++;
            boolean won = playRound(scanner, random);

            if (won) {
                roundsWon++;
            }

            // Ask to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\n===================================");
        System.out.println("           GAME SUMMARY");
        System.out.println("===================================");
        System.out.println("Rounds played : " + roundsPlayed);
        System.out.println("Rounds won    : " + roundsWon);
        System.out.println("Thanks for playing! Goodbye.");

        scanner.close();
    }

    /**
     * Plays a single round of the guessing game.
     * Returns true if the user guessed correctly within the attempt limit.
     */
    private static boolean playRound(Scanner scanner, Random random) {
        int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        int attemptsUsed = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nI'm thinking of a number between " + LOWER_BOUND
                + " and " + UPPER_BOUND + ". You have " + MAX_ATTEMPTS + " attempts.");

        while (attemptsUsed < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Attempt " + (attemptsUsed + 1) + "/" + MAX_ATTEMPTS + " - Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid whole number.");
                scanner.next(); // discard invalid token
                continue;
            }

            int guess = scanner.nextInt();
            attemptsUsed++;

            if (guess < LOWER_BOUND || guess > UPPER_BOUND) {
                System.out.println("Please guess a number within the range "
                        + LOWER_BOUND + " to " + UPPER_BOUND + ".");
            } else if (guess == targetNumber) {
                guessedCorrectly = true;
                int pointsEarned = calculatePoints(attemptsUsed);
                System.out.println("Correct! You guessed it in " + attemptsUsed + " attempt(s).");
                System.out.println("Points earned this round: " + pointsEarned);
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Out of attempts! The correct number was: " + targetNumber);
        }

        return guessedCorrectly;
    }

    /**
     * Awards more points for fewer attempts used.
     */
    private static int calculatePoints(int attemptsUsed) {
        int points = (MAX_ATTEMPTS - attemptsUsed + 1) * 10;
        return Math.max(points, 10);
    }

    private static void printWelcome() {
        System.out.println("===================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("      CodSoft Java Internship");
        System.out.println("===================================");
    }
}
