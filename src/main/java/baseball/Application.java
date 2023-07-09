package baseball;

import baseball.controller.GameController;
import baseball.service.BaseBallGenerateService;

public class Application {
    public static void main(String[] args) {
        BaseBallGenerateService baseBallGenerateService = new BaseBallGenerateService();
        GameController gameController = new GameController(baseBallGenerateService);
        gameController.gameStart();
    }
}
