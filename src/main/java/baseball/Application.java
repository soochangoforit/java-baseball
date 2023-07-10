package baseball;

import baseball.controller.GameController;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.service.BaseBallGenerateService;

public class Application {
    public static void main(String[] args) {
        BaseBallGenerateService baseBallGenerateService = new BaseBallGenerateService();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        GameController gameController = new GameController(baseBallGenerateService, numberGenerator);
        gameController.gameStart();
    }
}
