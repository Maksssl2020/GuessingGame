package guessing.game.sys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameEngineTest {
    private GuessingGameEngine game;

    @BeforeEach
    void setUp() {
        game = new GuessingGameEngine();
    }

    @Test
    public void testOneWrongGuess() {
        String guessedNumber = turnIntegerIntoString(game.getRandomNumber() - 1);
        String message = game.guessNumber(guessedNumber);
        assertEquals("Sorry, you didn't get it! Random number is greater than yours!", message);
    }

    @Test
    public void testOneCorrectGuess() {
        String guessedNumber = turnIntegerIntoString(game.getRandomNumber());
        String message = game.guessNumber(guessedNumber);
        assertEquals("You got it in 1 try!", message);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        makeTwoWrongGuesses();
        String guessedNumber = turnIntegerIntoString(game.getRandomNumber());
        String message = game.guessNumber(guessedNumber);
        assertEquals("You got it in 3 tries!", message);
    }

    @Test
    public void testThreeWrongGuesses() {
        makeTwoWrongGuesses();
        String guessedWrongNumber = turnIntegerIntoString(game.getRandomNumber() - 1);
        String message = game.guessNumber(guessedWrongNumber);
        String expectedMessage = String.format("Sorry, you've had 3 mistakes! Game is over! The random number was %d!", game.getRandomNumber());
        assertEquals(expectedMessage, message);
    }

    @Test
    public void testQuittingGameByEnterQ() {
        String enteredQ = "q";
        String message = game.guessNumber(enteredQ);
        assertEquals("Quitting game...", message);
    }

    private void makeTwoWrongGuesses() {
        String wrongGuessedNumber = turnIntegerIntoString(game.getRandomNumber() - 1);

        for (int i = 0; i < 2; i++) {
            game.guessNumber(wrongGuessedNumber);
        }
    }

    private String turnIntegerIntoString(int integerInput) {
        return String.valueOf(integerInput);
    }

    @Test
    public void testTurningTextIntoInteger() {
        String textNumber = "5";
        int result = game.turnTextInputIntoInteger(textNumber);
        assertEquals(5, result);
    }

    @Test
    public void testGuessedNumberGreaterThanRandomNumber() {
        int guessedNumber = game.getRandomNumber() + 1;
        String message = game.isRandomNumberGreaterOrLessThanGuessedNumber(guessedNumber);
        assertEquals("less", message);
    }

    @Test
    public void testGuessedNumberLessThanRandomNumber() {
        int guessedNumber = game.getRandomNumber() - 1;
        String message = game.isRandomNumberGreaterOrLessThanGuessedNumber(guessedNumber);
        assertEquals("greater", message);
    }

    @Test
    public void testGenerateNumbersBetween1And10() {
        int[] confirmedDrawnNumbers = new int[10];
        int sumOfConfirmedDrawnNumbers = 0;

        for (int i = 0; i < 100; i++) {
            GuessingGameEngine loopGame = new GuessingGameEngine();
            int drawnNumber = loopGame.getRandomNumber();
            confirmedDrawnNumbers[drawnNumber - 1] = 1;
        }

        for (int number : confirmedDrawnNumbers) {
            sumOfConfirmedDrawnNumbers += number;
        }

        assertEquals(10, sumOfConfirmedDrawnNumbers);
    }
}