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

    // TODO : 부생성자를 만들때 List 안의 제네릭은 알지 못 하기에 List<Integer>로는 파라미터 받을 수 없다.
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

    // TODO : 어떠한 결과 상태를 enum으로도 관리?? , 그렇다면 4 Strike 까지 존재한다면 모든 경우를 enum에 만들어야 함으로 적절 (x) 판단
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


    // TODO : IntStream rangeClosed() 사용법
    private int countStrike(BaseBallNumbers playerBaseBallNumbers) {
        return (int) IntStream.range(0, BASEBALL_NUMBER_SIZE)
                .filter(index -> isStrike(playerBaseBallNumbers, index))
                .count();
    }

    private boolean isStrike(BaseBallNumbers playerBaseBallNumbers, int index) {
        return baseBallNumbers.get(index).equals(playerBaseBallNumbers.numbers().get(index));
    }
}
