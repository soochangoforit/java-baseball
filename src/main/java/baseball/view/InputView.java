package baseball.view;

import baseball.view.dto.request.RestartValue;
import baseball.view.dto.request.PlayerBaseBallRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BASEBALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private InputView() { }

    public RestartValue scanRestartStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartStatus = Console.readLine();
        int restartValue = Integer.parseInt(restartStatus);
        return RestartValue.from(restartValue);
    }

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
