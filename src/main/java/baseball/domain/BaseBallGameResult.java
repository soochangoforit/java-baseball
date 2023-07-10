package baseball.domain;

public class BaseBallGameResult {

    private final Strike strike;

    private final Ball ball;

    public BaseBallGameResult(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }
}
