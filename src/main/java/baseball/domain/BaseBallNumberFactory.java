package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BaseBallNumberFactory {
    public List<Integer> generate(String playerBaseBallNumber) {
        return playerBaseBallNumber.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
