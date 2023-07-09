package baseball.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallNumber that = (BaseBallNumber) o;
        return baseBallNumber == that.baseBallNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseBallNumber);
    }
}
