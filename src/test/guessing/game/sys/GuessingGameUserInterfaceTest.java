package guessing.game.sys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameUserInterfaceTest {
    private GuessingGameUserInterface userInterface;

    @BeforeEach
    void setUp() {
        userInterface = new GuessingGameUserInterface();
    }

    @Test
    public void testCorrectUserInput() {
        String userInput = "5";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        String resultNumber = userInterface.askUserForEnterNumber();
        assertEquals(resultNumber, userInput);

        System.setIn(System.in);
    }

    @Test
    public void testNumberGreaterThan10() {
        String userInput = "11";
        boolean result = userInterface.checkEnteredNumber(userInput);
        assertFalse(result);
    }

    @Test
    public void testNumberLessThan1() {
        String userInput = "-1";
        boolean result = userInterface.checkEnteredNumber(userInput);
        assertFalse(result);
    }

    @Test
    public void testNumberBetween1And10() {
        String userInput = "6";
        boolean result = userInterface.checkEnteredNumber(userInput);
        assertTrue(result);
    }

    @Test
    public void testTurningTextIntoDigit() {
        String textNumber = "4";
        int numberAsDigit = userInterface.turnTextIntoDigit(textNumber);
        assertEquals(4, numberAsDigit);
    }

    @Test
    public void testEnteringQToQuit() {
        String userInput = "q";
        boolean result = userInterface.checkEnteredNumber(userInput);
        assertTrue(result);
    }

    @Test
    public void testEnterLetterInsteadOfNumber() {
        String userInput = "A";
        boolean result = userInterface.checkEnteredNumber(userInput);
        assertFalse(result);
    }
}