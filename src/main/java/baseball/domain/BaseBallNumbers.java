package baseball.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BaseBallNumbers {

    private static final int BASEBALL_NUMBER_SIZE = 3;

    private final List<BaseBallNumber> baseBallNumbers;

    public BaseBallNumbers(List<BaseBallNumber> baseBallNumbers) {
        validateBaseBallNumbers(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    public BaseBallNumbers(int... baseBallNumbers) {
        this(Arrays.stream(baseBallNumbers)
                .mapToObj(BaseBallNumber::new)
                .collect(toList()));
    }

    private void validateBaseBallNumbers(List<BaseBallNumber> baseBallNumbers) {
        if (!validateSize(baseBallNumbers)) {
            throw new IllegalArgumentException("야구공은 3개여야 합니다.");
        }

        if (!validateNotDuplicate(baseBallNumbers)) {
            throw new IllegalArgumentException("야구공은 중복되지 않는 숫자여야 합니다.");
        }
    }

    private boolean validateNotDuplicate(List<BaseBallNumber> baseBallNumbers) {
        return baseBallNumbers.stream()
                   .distinct()
                   .count() == BASEBALL_NUMBER_SIZE;
    }

    private boolean validateSize(List<BaseBallNumber> baseBallNumbers) {
        return baseBallNumbers.size() == BASEBALL_NUMBER_SIZE;
    }
}
