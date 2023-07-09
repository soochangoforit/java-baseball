package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseBallNumbersFactory;
import baseball.service.BaseBallGenerateService;

public class Application {
    public static void main(String[] args) {
        BaseBallNumbersFactory baseBallNumbersFactory = new BaseBallNumbersFactory();
        BaseBallGenerateService baseBallGenerateService = new BaseBallGenerateService(baseBallNumbersFactory);
        GameController gameController = new GameController(baseBallGenerateService);
        gameController.gameStart();
    }
}
