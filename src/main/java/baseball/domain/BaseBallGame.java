package baseball.domain;

public class BaseBallGame {

    private final BaseBallNumbers playerBaseBallNumbers;
    private final BaseBallNumbers randomBaseBallNumbers;

    public BaseBallGame(BaseBallNumbers playerBaseBallNumbers, BaseBallNumbers randomBaseBallNumbers) {
        this.playerBaseBallNumbers = playerBaseBallNumbers;
        this.randomBaseBallNumbers = randomBaseBallNumbers;
    }
}
