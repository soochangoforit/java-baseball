package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseBallNumberFactory;
import baseball.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new BaseBallNumberFactory(), new RandomNumberGenerator());
        gameController.run();
    }
}
