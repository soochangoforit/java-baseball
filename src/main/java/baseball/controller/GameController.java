package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.NumberGenerator;
import baseball.domain.BaseBallNumbersFactory;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.dto.request.PlayerBaseBallRequest;

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
        PlayerBaseBallRequest playerBaseBallNumber = inputView.scanBaseBallNumber();
        BaseBallNumbers playerBaseBallNumbers = baseBallNumbersFactory.createPlayerBaseBallNumbers(playerBaseBallNumber);
        BaseBallNumbers randomBaseBallNumbers = baseBallNumbersFactory.createRandomBaseBallNumbers(numberGenerator);



    }
}
