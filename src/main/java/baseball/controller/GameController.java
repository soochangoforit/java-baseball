package baseball.controller;

import baseball.domain.BaseBallNumberFactory;
import baseball.domain.BaseBallNumbers;
import baseball.domain.Generator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallNumberFactory baseBallNumberFactory;
    private final Generator generator;

    public GameController(BaseBallNumberFactory baseBallNumberFactory, Generator generator) {
        this.baseBallNumberFactory = baseBallNumberFactory;
        this.generator = generator;
    }

    public void run() {
        outputView.printGameStart();
        String playerBaseBallNumber = inputView.printScanNumberMessage();
        BaseBallNumbers playerBaseBallNumbers = baseBallNumberFactory.generate(playerBaseBallNumber);
        BaseBallNumbers randomBaseBallNumbers = generator.generateRandomNumber();
    }
}
