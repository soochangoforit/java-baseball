package baseball.domain;

import baseball.view.dto.request.PlayerBaseBallRequest;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseBallNumbersFactory {


    public BaseBallNumbers generateBaseBallNumbers(PlayerBaseBallRequest request) {
        String playerBaseBallNumber = request.baseBallNumber();
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }
}
