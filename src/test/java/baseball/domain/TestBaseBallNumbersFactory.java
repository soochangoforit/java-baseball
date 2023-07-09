package baseball.domain;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class TestBaseBallNumbersFactory {

    public static BaseBallNumbers fromValues(int... values) {
        return Arrays.stream(values)
                .mapToObj(BaseBallNumber::new)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }
}
