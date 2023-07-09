package baseball.view;

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

    public String scanBallBallNumber() {
        System.out.print(BASEBALL_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }


}
