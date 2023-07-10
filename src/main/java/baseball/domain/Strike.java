package baseball.domain;

import java.util.stream.Stream;

public enum Strike {

    NONE(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private final int strikeCount;

    Strike(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public static Strike from(int strikeCount) {
        return Stream.of(values())
                .filter(strike -> strike.strikeCount == strikeCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("스트라이크 카운트가 올바르지 않습니다."));
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isThreeStrike() {
        return this == THREE;
    }

    public boolean hasStrike() {
        return this != NONE;
    }
}
