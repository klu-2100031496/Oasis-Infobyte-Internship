
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalScore = 0;
        for (int round = 1; round <= 5; round++) {
            // Generate random number
            Random rand = new Random();
            int secretNumber = rand.nextInt(100) + 1;

            int guessCount = 0;
            int points = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && guessCount < 5) {
                System.out.print("Guess a number between 1 and 100: ");
                int guess = input.nextInt();
                guessCount++;

                if (guess == secretNumber) {
                    points = 10 - guessCount; // Award points based on attempts
                    totalScore += points;
                    System.out.println("Congratulations! You guessed the number in " + guessCount + " attempts.");
                    guessedCorrectly = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Guess again.");
                } else {
                    System.out.println("Too high! Guess again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number in 5 attempts. The number was " + secretNumber + ".");
            }

            System.out.println("Round " + round + " completed. Score for this round: " + points);
        }

        System.out.println("Final score: " + totalScore);

        input.close();
    }
}
