package baseball.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseBallNumbersFactory {


    public BaseBallNumbers generateBaseBallNumbers(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }
}
