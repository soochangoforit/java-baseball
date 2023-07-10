package baseball.view.dto.request;

import java.util.stream.Stream;

public enum RestartValue {

    RESTART(1),
    END(2);

    private final int restartNumber;

    RestartValue(int restartNumber) {
        this.restartNumber = restartNumber;
    }

    public static RestartValue from(int restartNumber) {
        return Stream.of(values())
                .filter(restartValue -> restartValue.restartNumber == restartNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("restart 혹은 end 하기 위한 올바른 입력값이 아닙니다."));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
