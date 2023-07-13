package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallGameResult;
import baseball.domain.BaseBallNumbers;
import baseball.domain.BaseBallNumbersFactory;
import baseball.domain.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.dto.request.PlayerBaseBallRequest;
import baseball.view.dto.request.RestartRequest;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallNumbersFactory baseBallNumbersFactory;
    private final NumberGenerator numberGenerator;

    public GameController(BaseBallNumbersFactory baseBallNumbersFactory, NumberGenerator numberGenerator) {
        this.baseBallNumbersFactory = baseBallNumbersFactory;
        this.numberGenerator = numberGenerator;
    }


    public void gameStart() {
        outputView.printGameStartMessage();

        do {
            playGame();
        } while (isGameRestart());
    }

    private void playGame() {
        BaseBallNumbers randomBaseBallNumbers = baseBallNumbersFactory.createRandomBaseBallNumbers(numberGenerator);
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(randomBaseBallNumbers);

        BaseBallGameResult gameResult;
        do {
            gameResult = playTurn(baseBallGame);
        } while (gameResult.isNotFinished());

    }

    private BaseBallGameResult playTurn(BaseBallGame baseBallGame) {
        PlayerBaseBallRequest playerBaseBallNumber = inputView.scanBaseBallNumber();
        BaseBallNumbers playerBaseBallNumbers = baseBallNumbersFactory.createPlayerBaseBallNumbers(playerBaseBallNumber);
        BaseBallGameResult gameResult = baseBallGame.startGame(playerBaseBallNumbers);
        outputView.printGameResult(gameResult);
        return gameResult;
    }

    private boolean isGameRestart() {
        RestartRequest restartRequest = inputView.scanRestartStatus();
        return restartRequest.isRestart();
    }
}
