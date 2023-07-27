package guessing.game.sys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameControllerTest {
    private GuessingGameController game;

    @BeforeEach
    void setUp() {
        game = new GuessingGameController();
    }

    @Test
    public void testWinningMessageResult() {
        String gameResultMessage = "You got it";
        boolean result = game.checkGameResult(gameResultMessage);
        assertFalse(result);
    }

    @Test
    public void testLoosingMessageResult() {
        String gameResultMessage = "Game is over";
        boolean result = game.checkGameResult(gameResultMessage);
        assertFalse(result);
    }

    @Test
    public void testQuittingMessageResult() {
        String gameResultMessage = "Quitting game";
        boolean result = game.checkGameResult(gameResultMessage);
        assertFalse(result);
    }
}