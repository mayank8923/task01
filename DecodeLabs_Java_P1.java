import java.util.Random;
import java.util.Scanner;


public class DecodeLabs_Java_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minrange = 1;
        int maxrange = 100;
        int maxAttempts = 10;
        int roundswon = 0;
        int totalrounds = 0;

        System.out.println("Welcome to The Guessing Game");
        boolean playAgain = true;
        while(playAgain){
            totalrounds++;
            int targetnumber = random.nextInt(maxrange - minrange + 1 ) + minrange;
            int attempts = 0;
            boolean guessedcorrectly = false;
            System.out.println("\n--- Round " + totalrounds + " ---");
            System.out.println("I have generated a number between " + minrange + " and " + maxrange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !guessedcorrectly) {
                System.out.print("Enter your guess: ");

                // Check if the user entered an integer to prevent crashes
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // consume the invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                // Provide feedback
                if (guess == targetnumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedcorrectly = true;
                    roundswon++;
                } else if (guess < targetnumber) {
                    System.out.println("Too low! Attempts remaining: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Too high! Attempts remaining: " + (maxAttempts - attempts));
                }
            }

            if (!guessedcorrectly) {
                System.out.println("You've used all your attempts. The correct number was: " + targetnumber);
            }

            // Ask for another round
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.startsWith("y");
        }

        // Display final score
        System.out.println("\n=== Game Over ===");
        System.out.println("Total rounds played: " + totalrounds);
        System.out.println("Total rounds won: " + roundswon);

        scanner.close();
    }
}


