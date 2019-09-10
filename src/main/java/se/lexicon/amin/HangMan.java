package se.lexicon.amin;

import java.util.Scanner;

public class HangMan {
    private static String secretWord = "LEXICON";
    private int numberOfGuessesMadeCounter;
    private char[] hangManString = new char[secretWord.length()];



    private StringBuilder allGuesses = new StringBuilder();

    public HangMan() {
        this.hangManString = initializeHangManString();
    }

    /*

    public HangMan(int numberOfGuessesMade, char[] gameProgressWithCorrectGuesses, StringBuilder allGuessesSoFar) {
        this.numberOfGuessesMade = numberOfGuessesMade;
        this.gameProgressWithCorrectGuesses = gameProgressWithCorrectGuesses;
        this.allGuessesSoFar = allGuessesSoFar;
    }

    */

    public void play() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------- Welcome to Hangman ----------- \n");

        while (isGuessesLeft(numberOfGuessesMadeCounter)) {

            System.out.print(hangManString);
            System.out.println("    (contains " + secretWord.length() + " characters)\n");
            System.out.println("You have " + (8 - numberOfGuessesMadeCounter) + " guesses left\n");
            System.out.println("Guesses made so far: " + allGuesses + "\n");

            System.out.print("Make your guess: ");
            String guessAsString = scanner.nextLine().toUpperCase();
            System.out.println ("\n*********************************");

            if (guessAsString.length() == 1) {
                char guess = guessAsString.charAt(0);
                if (isNewGuess(guess)) {
                    if (isCorrectGuess(guess)) {
                        System.out.println("\nCorrect guess!\n");
                        addCorrectGuessToHangManString(guess);
                        addGuessToAllGuesses(guess);

                        if (secretWord.equals(new String(hangManString))) {
                            System.out.println(hangManString);
                            System.out.println("\nCongratulations! You won!");
                            break;
                        }
                    } else {
                        System.out.println("\nWrong guess. Try again!\n");
                        addGuessToAllGuesses(guess);
                        incrementNumberOfGuessesMadeCounter();
                    }
                } else {
                    System.out.println("\nThis guess has already been made. Try again\n");
                }
            } else if (guessAsString.length() == secretWord.length()) {
                if (guessAsString.contains(secretWord)) {
                    System.out.println("Correct word! Congratulations! You won!\n");
                    System.out.println(secretWord);
                    break;
                } else {
                    System.out.println("\nWrong word! You lost!");
                    break;
                }
            } else {
                System.out.println("\nWrong number of characters. Guess one (1) character or the whole word ("
                        + secretWord.length() + " characters)\n");
            }


        }

        if (!isGuessesLeft(numberOfGuessesMadeCounter)) {
        System.out.println("No guesses left. You lost!");
        }


    }



    public boolean isNewGuess(char guess) {
       String guessAsString = Character.toString(guess);
       if (allGuesses.indexOf(guessAsString) == -1) {
           return true;
       } else {
           return false;
       }
    }

    private void incrementNumberOfGuessesMadeCounter() {
        numberOfGuessesMadeCounter++;
    }

    public boolean isGuessesLeft(int numberOfGuessesMade) {
        if (numberOfGuessesMade < 8) {
            return true;
        } else {
            return false;
        }

    }
    public boolean isCorrectGuess(char guess) {
        String guessAsString = Character.toString(guess);
        if ( secretWord.contains(guessAsString)) {
            return true;
        } else {
            return false;
        }
    }

    //Public just for testing purpose.
    public void addGuessToAllGuesses(char guess) {
        allGuesses.append(guess);
    }

    public int getIndexOfCorrectGuess(char guess) {
        return secretWord.indexOf(guess);
    }

    private void addCorrectGuessToHangManString(char guess) {
        int index = getIndexOfCorrectGuess(guess);
        hangManString[index] = guess;
    }


    private char[] initializeHangManString() {
        char[] charArray = new char[secretWord.length()];
        for (int i=0; i < secretWord.length(); i++){
            charArray[i] = '_';
        }
        return charArray;
    }

  //Getters

    public int getNumberOfGuessesMadeCounter() {
        return numberOfGuessesMadeCounter;
    }

    public char[] getHangManString() {
        return hangManString;
    }

    public StringBuilder getAllGuesses() {
        return allGuesses;
    }
}
