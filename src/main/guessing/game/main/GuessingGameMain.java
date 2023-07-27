package guessing.game.main;


import guessing.game.sys.GuessingGameController;

public class GuessingGameMain {
    public static void main(String[] args) {
        GuessingGameController game = new GuessingGameController();
        game.startGuessingGame();
    }
}
