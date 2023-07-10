package baseball.domain;

public class BaseBallGame {

    private final BaseBallNumbers randomBaseBallNumbers;
    private final BaseBallGameStatus baseBallGameStatus;

    private BaseBallGame(BaseBallNumbers randomBaseBallNumbers, BaseBallGameStatus baseBallGameStatus) {
        this.randomBaseBallNumbers = randomBaseBallNumbers;
        this.baseBallGameStatus = baseBallGameStatus;
    }


    public static BaseBallGame initializeGame(BaseBallNumbers randomBaseBallNumbers) {
        return new BaseBallGame(randomBaseBallNumbers, BaseBallGameStatus.NOT_FINISH);
    }

    public boolean isFinished() {
        return baseBallGameStatus.isFinished();
    }


    public void startGame(BaseBallNumbers playerBaseBallNumbers) {
        Strike strike = randomBaseBallNumbers.countStrike(playerBaseBallNumbers);
        Ball ball = randomBaseBallNumbers.countBall(playerBaseBallNumbers, strike);
    }
}
