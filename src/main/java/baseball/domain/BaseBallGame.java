package baseball.domain;

public class BaseBallGame {
    private final BaseBallNumbers randomBaseBallNumbers;
    private BaseBallGameStatus gameStatus;

    public BaseBallGame(BaseBallNumbers randomBaseBallNumbers, BaseBallGameStatus gameStatus) {
        this.randomBaseBallNumbers = randomBaseBallNumbers;
        this.gameStatus = gameStatus;
    }

    public BaseBallGame(BaseBallNumbers randomBaseBallNumbers) {
        this(randomBaseBallNumbers, new BaseBallGameStatus(false));
    }

    public GameResult play(BaseBallNumbers playerBaseBallNumbers) {
        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);
        isAllStrike(result);
        return result;
    }

    private void isAllStrike(GameResult result) {
        if(result.isAllStrike()) {
            gameStatus = new BaseBallGameStatus(true);
        }
    }

    public boolean isNotEnd() {
        return gameStatus.equals(new BaseBallGameStatus(false));
    }
}
