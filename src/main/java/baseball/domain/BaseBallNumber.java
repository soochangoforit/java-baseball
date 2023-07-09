package baseball.domain;

public class BaseBallNumber {
    
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    
    private final int baseBallNumber;
    
    public BaseBallNumber(int baseBallNumber) {
        validateBaseBallNumber(baseBallNumber);
        this.baseBallNumber = baseBallNumber;
    }

    private void validateBaseBallNumber(int baseBallNumber) {
        if (!validateInRange(baseBallNumber)) {
            throw new IllegalArgumentException("야구공은 1~9 사이의 숫자여야 합니다.");
        }
    }

    private static boolean validateInRange(int baseBallNumber) {
        return baseBallNumber >= MIN_BASEBALL_NUMBER && baseBallNumber <= MAX_BASEBALL_NUMBER;
    }
}
