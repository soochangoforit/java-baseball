package baseball.view;

public class InputValidator {

    private static final int BASEBALL_NUMBER_SIZE = 3;
    private static final String BASEBALL_NUMBER_RANGE_REGEX = "^[1-9]*$";

    public static void validatePlayerBaseBallNumber(String playerBaseBallNumber) {
        if (!validateNumberSize(playerBaseBallNumber) || !validateNumberInRange(playerBaseBallNumber)
                || !validateNotDuplicate(playerBaseBallNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateNumberInRange(String playerBaseBallNumber) {
        return playerBaseBallNumber.matches(BASEBALL_NUMBER_RANGE_REGEX);
    }


    private static boolean validateNotDuplicate(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .distinct()
                .count() == BASEBALL_NUMBER_SIZE;
    }


    private static boolean validateNumberSize(String playerBaseBallNumber) {
        return playerBaseBallNumber.length() == BASEBALL_NUMBER_SIZE;
    }
}
