package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator implements Generator {

    public BaseBallNumbers generateRandomNumber() {
        Set<BaseBallNumber> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(new BaseBallNumber(randomNumber));
        }

        return new BaseBallNumbers(randomNumbers);
    }

}
