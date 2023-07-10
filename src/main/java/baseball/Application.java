package baseball;

import baseball.controller.GameController;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.BaseBallNumbersFactory;

public class Application {
    public static void main(String[] args) {
        BaseBallNumbersFactory baseBallNumbersFactory = new BaseBallNumbersFactory();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        GameController gameController = new GameController(baseBallNumbersFactory, numberGenerator);
        gameController.gameStart();
    }
}
