package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.BaseBallNumbersFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallNumbersFactory baseBallNumbersFactory;

    public GameController(BaseBallNumbersFactory baseBallNumbersFactory) {
        this.baseBallNumbersFactory = baseBallNumbersFactory;
    }


    public void gameStart() {
        outputView.printGameStartMessage();
        String playerBaseBallNumber = inputView.scanBaseBallNumber();
        BaseBallNumbers playerBaseBallNumbers = baseBallNumbersFactory.generateBaseBallNumbers(playerBaseBallNumber);

    }
}
