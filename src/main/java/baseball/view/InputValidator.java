package baseball.view;

public class InputValidator {

    private static final int BASEBALL_NUMBER_SIZE = 3;

    public static String validatePlayerBaseBallNumber(String playerBaseBallNumber) {
        if (!validateNumberSize(playerBaseBallNumber) || !validateNumber(playerBaseBallNumber)
            || !validateNotDuplicate(playerBaseBallNumber)) {
            throw new IllegalArgumentException();
        }

        return playerBaseBallNumber;
    }

    private static boolean validateNotDuplicate(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .distinct()
                .count() == BASEBALL_NUMBER_SIZE;
    }

    private static boolean validateNumber(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .allMatch(Character::isDigit);
    }

    private static boolean validateNumberSize(String playerBaseBallNumber) {
        return playerBaseBallNumber.length() == BASEBALL_NUMBER_SIZE;
    }
}
