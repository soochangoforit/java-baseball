package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();


    public void gameStart() {
        outputView.printGameStartMessage();
        String playerBaseBallNumber = inputView.scanBallBallNumber();
    }
}
