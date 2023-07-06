package baseball.view;

import static baseball.domain.BaseBallNumbers.BASEBALL_NUMBER_SIZE;

public class InputValidator {
    private static final String NUMBER_REGEX = "^[1-9]*$";

    public static void validateInputNumbers(String inputNumbers) {
        if (!validateLength(inputNumbers) || !validateNumberInRange(inputNumbers) || !validateDuplicate(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateDuplicate(String inputNumbers) {
        return inputNumbers.chars()
                .distinct()
                .count() == BASEBALL_NUMBER_SIZE;
    }

    private static boolean validateNumberInRange(String numbers) {
        return numbers.matches(NUMBER_REGEX);
    }

    private static boolean validateLength(String numbers) {
        return numbers.length() == BASEBALL_NUMBER_SIZE;
    }
}
