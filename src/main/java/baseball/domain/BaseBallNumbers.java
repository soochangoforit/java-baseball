package baseball.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBallNumbers {

    public static final int BASEBALL_NUMBER_SIZE = 3;

    private final List<BaseBallNumber> baseBallNumbers;

    public BaseBallNumbers(List<BaseBallNumber> baseBallNumbers) {
        validateDuplicate(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    public BaseBallNumbers(Set<BaseBallNumber> baseBallNumbers) {
        this(new ArrayList<>(baseBallNumbers));
    }

    public BaseBallNumbers(int... numbers) {
        this(IntStream.of(numbers)
                .mapToObj(BaseBallNumber::new)
                .collect(Collectors.toList()));
    }


    private void validateDuplicate(List<BaseBallNumber> baseBallNumbers) {
        Set<BaseBallNumber> uniqueNumbers = new HashSet<>(baseBallNumbers);
        if (uniqueNumbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new BaseBallGameException();
        }
    }


    public int size() {
        return baseBallNumbers.size();
    }

    public List<BaseBallNumber> numbers() {
        return baseBallNumbers;
    }


    public GameResult play(BaseBallNumbers playerBaseBallNumbers) {
        int strikeCount = countStrike(playerBaseBallNumbers);
        int ballCount = countBall(playerBaseBallNumbers, strikeCount);
        return new GameResult(strikeCount, ballCount);
    }

    private int countBall(BaseBallNumbers playerBaseBallNumbers, int strikeCount) {
        return (int) playerBaseBallNumbers.numbers()
                .stream()
                .filter(this::isBall)
                .count() - strikeCount;
    }

    private boolean isBall(BaseBallNumber playerBaseBallNumber) {
        return this.baseBallNumbers.contains(playerBaseBallNumber);
    }


    private int countStrike(BaseBallNumbers playerBaseBallNumbers) {
        return (int) IntStream.range(0, BASEBALL_NUMBER_SIZE)
                .filter(index -> isStrike(playerBaseBallNumbers, index))
                .count();
    }

    private boolean isStrike(BaseBallNumbers playerBaseBallNumbers, int index) {
        return baseBallNumbers.get(index).equals(playerBaseBallNumbers.numbers().get(index));
    }
}
