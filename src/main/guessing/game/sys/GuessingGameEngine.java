package guessing.game.sys;

import java.util.Random;

class GuessingGameEngine {
    public static final int MAX_POSSIBLE_GUESSES = 3;
    private final int randomNumber = new Random().nextInt(10) + 1;
    private int guessCounter = 0;

    protected String guessNumber(String guessedNumber) {
        guessCounter++;
        String resultMessage;
        String tryWordVariation = guessCounter == 1 ? "try" : "tries";

        if ("q".equalsIgnoreCase(guessedNumber)) {
            resultMessage = "Quitting game...";
        } else if (guessCounter == MAX_POSSIBLE_GUESSES && turnTextInputIntoInteger(guessedNumber) != randomNumber) {
            resultMessage = String.format("Sorry, you've had %d mistakes! Game is over! The random number was %d!", guessCounter, randomNumber);
        } else if (turnTextInputIntoInteger(guessedNumber) == randomNumber){
            resultMessage = String.format("You got it in %d %s!", guessCounter, tryWordVariation);
        } else {
            String isGreaterOrLess = isRandomNumberGreaterOrLessThanGuessedNumber(turnTextInputIntoInteger(guessedNumber));
            resultMessage = String.format("Sorry, you didn't get it! Random number is %s than yours!", isGreaterOrLess);
        }

        return resultMessage;
    }

    protected String isRandomNumberGreaterOrLessThanGuessedNumber(int guessedNumber) {
        String isGreaterOrLess;

        if (randomNumber > guessedNumber) {
            isGreaterOrLess = "greater";
        } else {
            isGreaterOrLess = "less";
        }

        return isGreaterOrLess;
    }

    protected int turnTextInputIntoInteger(String textInput) {
        return Integer.parseInt(textInput);
    }

    protected int getRandomNumber() {
        return randomNumber;
    }
}
