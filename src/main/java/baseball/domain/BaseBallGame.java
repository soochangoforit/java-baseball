package baseball.domain;

import static baseball.domain.BaseBallGameStatus.CONTINUE;
import static baseball.domain.BaseBallGameStatus.END;

public class BaseBallGame {
    private final BaseBallNumbers randomBaseBallNumbers;
    private BaseBallGameStatus gameStatus;

    public BaseBallGame(BaseBallNumbers randomBaseBallNumbers, BaseBallGameStatus gameStatus) {
        this.randomBaseBallNumbers = randomBaseBallNumbers;
        this.gameStatus = gameStatus;
    }

    public BaseBallGame(BaseBallNumbers randomBaseBallNumbers) {
        this(randomBaseBallNumbers, CONTINUE);
    }

    public GameResult play(BaseBallNumbers playerBaseBallNumbers) {
        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);
        updateGameStatusOnAllStrikes(result);
        return result;
    }

    private void updateGameStatusOnAllStrikes(GameResult result) {
        if(result.isAllStrike()) {
            gameStatus = END;
        }
    }

    public boolean isNotEnd() {
        return gameStatus.isNotEnd();
    }
}
