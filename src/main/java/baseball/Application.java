package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseBallNumberFactory;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new BaseBallNumberFactory());
        gameController.run();
    }
}
