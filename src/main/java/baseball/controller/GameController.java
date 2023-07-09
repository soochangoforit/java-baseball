package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.service.BaseBallGenerateService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.dto.request.PlayerBaseBallRequest;

public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallGenerateService baseBallGenerateService;

    public GameController(BaseBallGenerateService baseBallGenerateService) {
        this.baseBallGenerateService = baseBallGenerateService;
    }


    public void gameStart() {
        outputView.printGameStartMessage();
        PlayerBaseBallRequest playerBaseBallNumber = inputView.scanBaseBallNumber();
        BaseBallNumbers playerBaseBallNumbers = baseBallGenerateService.createPlayerBaseBallNumbers(playerBaseBallNumber);


    }
}
