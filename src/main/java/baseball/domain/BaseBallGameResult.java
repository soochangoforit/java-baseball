package baseball.domain;

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
}
