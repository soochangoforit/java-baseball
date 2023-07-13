package baseball.view;

import baseball.view.dto.request.PlayerBaseBallRequest;
import baseball.view.dto.request.RestartRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BASEBALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
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

    public RestartRequest scanRestartStatus() {
        System.out.println(RESTART_INPUT_MESSAGE);
        String restartStatus = Console.readLine();
        int restartValue = Integer.parseInt(restartStatus);
        return RestartRequest.from(restartValue);
    }


}
