package baseball.domain;

public class BaseBallGame {
    private final BaseBallNumbers randomBaseBallNumbers;

    public BaseBallGame(BaseBallNumbers randomBaseBallNumbers) {
        this.randomBaseBallNumbers = randomBaseBallNumbers;
    }

    public void play(BaseBallNumbers playerBaseBallNumbers) {
        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);

    }
}
