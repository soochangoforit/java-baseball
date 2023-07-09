package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseBallNumbersFactory;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new BaseBallNumbersFactory());
        gameController.gameStart();
    }
}
