package baseball.domain;

public class BaseBallGame {
    private final BaseBallNumbers randomBaseBallNumbers;

    public BaseBallGame(BaseBallNumbers randomBaseBallNumbers) {
        this.randomBaseBallNumbers = randomBaseBallNumbers;
    }

    public GameResult play(BaseBallNumbers playerBaseBallNumbers) {
        return randomBaseBallNumbers.play(playerBaseBallNumbers);
    }
}
