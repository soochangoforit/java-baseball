package baseball.controller;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;


public class GameController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private final BaseBallNumberFactory baseBallNumberFactory;
    private final Generator generator;

    public GameController(BaseBallNumberFactory baseBallNumberFactory, Generator generator) {
        this.baseBallNumberFactory = baseBallNumberFactory;
        this.generator = generator;
    }

    public void run() {
        outputView.printGameStart();
        boolean keepPlaying = true;
        while (keepPlaying) {
            BaseBallNumbers randomBaseBallNumbers = baseBallNumberFactory.generateRandomNumber(generator);
            BaseBallGame game = new BaseBallGame(randomBaseBallNumbers);
            playUntilfinish(game);
            keepPlaying = inputView.askKeepPlaying();
        }
    }

    private void playUntilfinish(BaseBallGame game) {
        while (game.isNotEnd()) {
            String playerBaseBallNumber = inputView.printScanNumberMessage();
            BaseBallNumbers playerBaseBallNumbers = baseBallNumberFactory.generate(playerBaseBallNumber);
            GameResult result = game.play(playerBaseBallNumbers);
            outputView.printGameResult(result);
        }
    }
}
