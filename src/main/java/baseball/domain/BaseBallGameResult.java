package baseball.domain;

import java.util.Objects;

public class BaseBallGameResult {

    private final Strike strike;

    private final Ball ball;

    public BaseBallGameResult(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public BaseBallGameResult(int strikeCount, int ballCount) {
        this(Strike.from(strikeCount), Ball.from(ballCount));
    }

    public boolean hasBall() {
        return ball.hasBall();
    }

    public int getBallCount() {
        return ball.getBallCount();
    }

    public boolean hasStrike() {
        return strike.hasStrike();
    }

    public int getStrikeCount() {
        return strike.getStrikeCount();
    }

    public boolean hasNothing() {
        return !hasBall() && !hasStrike();
    }

    public boolean hasAllStrike() {
        return strike.isThreeStrike();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallGameResult that = (BaseBallGameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

    public boolean isNotFinished() {
        return !hasAllStrike();
    }
}
