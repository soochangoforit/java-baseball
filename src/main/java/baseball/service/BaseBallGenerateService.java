package baseball.service;

import baseball.domain.BaseBallNumber;
import baseball.domain.BaseBallNumbers;
import baseball.view.dto.request.PlayerBaseBallRequest;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseBallGenerateService {

    public BaseBallNumbers createPlayerBaseBallNumbers(PlayerBaseBallRequest request) {
        String playerBaseBallNumber = request.baseBallNumber();
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }
}
