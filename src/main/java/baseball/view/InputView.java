package baseball.view;

import baseball.view.dto.request.PlayerBaseBallRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BASEBALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private InputView() { }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public PlayerBaseBallRequest scanBaseBallNumber() {
        System.out.print(BASEBALL_NUMBER_INPUT_MESSAGE);
        String playerBaseBallNumbers = Console.readLine();
        return new PlayerBaseBallRequest(playerBaseBallNumbers);
    }


}
