//java
import java.util.Random; 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;  // Game dobara play kr sakte hai simple yes\no ans dekar..

        do {
            int numberToGuess = random.nextInt(100) + 1; // Number range 1 to 200
            int userGuess = -1; // Initialize with an invalid guess
            int attempts = 0;
            int score = 100; // Starting score
            int maxAttempts = 10; // Maximum attempts allowed

            System.out.println("Welcome to the Extended Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (userGuess != numberToGuess && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                try {
                    userGuess = scanner.nextInt();
                    attempts++;

                    // Adding a hint system based on proximity
                    if (userGuess < numberToGuess) {
                        if (numberToGuess - userGuess <= 10) {
                            System.out.println("Very close! Just a bit higher.");
                        } else {
                            System.out.println("Too low! Try again.");
                        }
                    } else if (userGuess > numberToGuess) {
                        if (userGuess - numberToGuess <= 10) {
                            System.out.println("Very close! Just a bit lower.");
                        } else {
                            System.out.println("Too high! Try again.");
                        }
                    }

                    // Decrease score based on attempts
                    score -= 10;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                System.out.println("Your score: " + score);
            } else {
                System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess);
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}