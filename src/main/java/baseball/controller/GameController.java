package baseball.controller;

import baseball.domain.BaseBallNumberFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallNumberFactory baseBallNumberFactory;

    public GameController(BaseBallNumberFactory baseBallNumberFactory) {
        this.baseBallNumberFactory = baseBallNumberFactory;
    }

    public void run() {
        outputView.printGameStart();
        String baseBallNumber = inputView.printScanNumberMessage();
        List<Integer> playerBaseBallNumbers = baseBallNumberFactory.generate(baseBallNumber);
    }
}
