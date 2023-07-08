package baseball.domain;

import java.util.HashSet;
import java.util.Set;

import static baseball.domain.BaseBallNumbers.BASEBALL_NUMBER_SIZE;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseBallNumberFactory {

    public BaseBallNumbers generate(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

    public BaseBallNumbers generateRandomNumber(Generator generator) {
        Set<BaseBallNumber> baseBallNumbers = new HashSet<>();
        while (baseBallNumbers.size() < BASEBALL_NUMBER_SIZE) {
            baseBallNumbers.add(new BaseBallNumber(generator.generateRandomNumber()));
        }
        return new BaseBallNumbers(baseBallNumbers);

    }
}
