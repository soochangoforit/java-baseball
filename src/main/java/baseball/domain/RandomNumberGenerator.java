package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements Generator {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

}
