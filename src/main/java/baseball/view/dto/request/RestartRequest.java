package baseball.view.dto.request;

import java.util.stream.Stream;

public enum RestartRequest {

    RESTART(1),
    END(2);

    private final int restartNumber;

    RestartRequest(int restartNumber) {
        this.restartNumber = restartNumber;
    }

    public static RestartRequest from(int restartNumber) {
        return Stream.of(values())
                .filter(restartRequest -> restartRequest.restartNumber == restartNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("restart 혹은 end 하기 위한 올바른 입력값이 아닙니다."));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
