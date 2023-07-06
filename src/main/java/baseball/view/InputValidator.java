package baseball.view;

public class InputValidator {

    private static final int VALID_BASEBALL_NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEX = "^[1-9]*$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void validateInputNumbers(String inputNumbers) {
        if (!validateLength(inputNumbers) || !validateNumber(inputNumbers) || !validateDuplicate(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateDuplicate(String inputNumbers) {
        return inputNumbers.chars()
                .distinct()
                .count() == VALID_BASEBALL_NUMBER_LENGTH;
    }

    private static boolean validateInRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private static boolean validateNumber(String numbers) {
        return numbers.matches(NUMBER_REGEX);
    }

    private static boolean validateLength(String numbers) {
        return numbers.length() == VALID_BASEBALL_NUMBER_LENGTH;
    }
}
