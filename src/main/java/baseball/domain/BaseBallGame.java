package baseball.domain;

import static baseball.domain.BaseBallGameStatus.FINISH;
import static baseball.domain.BaseBallGameStatus.NOT_FINISH;

public class BaseBallGame {

    private final BaseBallNumbers randomBaseBallNumbers;
    private BaseBallGameStatus baseBallGameStatus;

    private BaseBallGame(BaseBallNumbers randomBaseBallNumbers, BaseBallGameStatus baseBallGameStatus) {
        this.randomBaseBallNumbers = randomBaseBallNumbers;
        this.baseBallGameStatus = baseBallGameStatus;
    }


    public static BaseBallGame initializeGame(BaseBallNumbers randomBaseBallNumbers) {
        return new BaseBallGame(randomBaseBallNumbers, NOT_FINISH);
    }

    public boolean isFinished() {
        return baseBallGameStatus.isFinished();
    }


    public void startGame(BaseBallNumbers playerBaseBallNumbers) {
        Strike strike = randomBaseBallNumbers.countStrike(playerBaseBallNumbers);
        Ball ball = randomBaseBallNumbers.countBall(playerBaseBallNumbers, strike);
        updateGameStatus(strike);
    }

    private void updateGameStatus(Strike strike) {
        if (strike.isThreeStrike()) {
            baseBallGameStatus = FINISH;
        }
    }

}
