package baseball.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseBallNumberFactory {

    // TODO : collectingAndThen에 대해서 학습하기
    public BaseBallNumbers generate(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }
}
