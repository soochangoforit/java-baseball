package baseball.domain;

import java.util.stream.Stream;

public enum Ball {

    NONE(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private final int ballCount;

    Ball(int ballCount) {
        this.ballCount = ballCount;
    }

    public static Ball from(int ballCount) {
        return Stream.of(values())
                .filter(ball -> ball.ballCount == ballCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("볼 카운트가 올바르지 않습니다."));
    }

    public boolean hasBall() {
        return this != NONE;
    }

    public int getBallCount() {
        return ballCount;
    }

}
