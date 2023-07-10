package baseball.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseball.view.dto.request.PlayerBaseBallRequest;

public class BaseBallNumbersFactory {

    public BaseBallNumbers createPlayerBaseBallNumbers(PlayerBaseBallRequest request) {
        String playerBaseBallNumber = request.baseBallNumber();
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

    public BaseBallNumbers createRandomBaseBallNumbers(NumberGenerator numberGenerator) {
        return Stream.generate(numberGenerator::generate)
                .distinct()
                .limit(3)
                .map(BaseBallNumber::new)
                .collect(Collectors.collectingAndThen(toList(), BaseBallNumbers::new));
    }
}
