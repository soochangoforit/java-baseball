package baseball.domain;

import java.util.Objects;

public class BaseBallNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final int number;

    public BaseBallNumber(int number) {
        validateInRange(number);
        this.number = number;
    }

    private void validateInRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new BaseBallGameException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
