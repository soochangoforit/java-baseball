package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.NumberGenerator;
import baseball.service.BaseBallGenerateService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.dto.request.PlayerBaseBallRequest;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallGenerateService baseBallGenerateService;
    private final NumberGenerator numberGenerator;

    public GameController(BaseBallGenerateService baseBallGenerateService, NumberGenerator numberGenerator) {
        this.baseBallGenerateService = baseBallGenerateService;
        this.numberGenerator = numberGenerator;
    }


    public void gameStart() {
        outputView.printGameStartMessage();
        PlayerBaseBallRequest playerBaseBallNumber = inputView.scanBaseBallNumber();
        BaseBallNumbers playerBaseBallNumbers = baseBallGenerateService.createPlayerBaseBallNumbers(playerBaseBallNumber);



    }
}
