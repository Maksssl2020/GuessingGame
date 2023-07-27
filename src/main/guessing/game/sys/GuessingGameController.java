package guessing.game.sys;

public class GuessingGameController {
    private final GuessingGameEngine gameEngine;
    private final GuessingGameUserInterface userInterface;

    public GuessingGameController() {
        gameEngine = new GuessingGameEngine();
        userInterface = new GuessingGameUserInterface();
    }

    public void startGuessingGame() {
        boolean gameResult;

        System.out.println("You have only 3 chances to guess random number");
        System.out.println("To quit game please enter Q");
        do {
            String guessedNumber = userInterface.askUserForEnterNumber();
            String gameResultMessage = gameEngine.guessNumber(guessedNumber);
            gameResult = checkGameResult(gameResultMessage);
            System.out.println(gameResultMessage);
        } while (gameResult);
    }

    protected boolean checkGameResult(String gameResultMessage) {
        boolean checkingResult = true;

        if (gameResultMessage.contains("Game is over")) {
            checkingResult = false;
        } else if (gameResultMessage.contains("You got it")) {
            checkingResult = false;
        } else if (gameResultMessage.contains("Quitting")) {
            checkingResult = false;
        }

        return  checkingResult;
    }
}
