package baseball.controller;

import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();


    public void gameStart() {
        outputView.printGameStartMessage();
    }
}
