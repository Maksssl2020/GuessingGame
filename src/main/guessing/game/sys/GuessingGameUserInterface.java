package guessing.game.sys;

import java.util.Scanner;

class GuessingGameUserInterface {
    protected String askUserForEnterNumber() {
        String textUserInput;
        boolean checkingResult;

        System.out.println("Enter number between 1 and 10: ");
        do {
            textUserInput = new Scanner(System.in).nextLine();
            checkingResult = checkEnteredNumber(textUserInput);
        } while (!checkingResult);

        return textUserInput;
    }

    protected boolean checkEnteredNumber(String numberToCheck) {
        boolean checkingResult = true;
        String numberToCheckRegex = "-?\\d{1,2}+";

        if ("q".equalsIgnoreCase(numberToCheck)) {
            System.out.println("Thank you for playing in guessing game!");
        } else if (!numberToCheck.matches(numberToCheckRegex)) {
            System.out.println("You didn't enter a number! Try again: ");
            checkingResult = false;
        } else if (turnTextIntoDigit(numberToCheck) > 10) {;
            System.out.println("Entered number is greater than 10! Try again: ");
            checkingResult = false;
        } else if (turnTextIntoDigit(numberToCheck) < 1) {
            System.out.println("Entered number is less than 1! Try again: ");
            checkingResult = false;
        }

        return checkingResult;
    }

    protected int turnTextIntoDigit(String textNumber) {
        return Integer.parseInt(textNumber);
    }
}
