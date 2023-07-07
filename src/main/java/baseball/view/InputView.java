package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String SCAN_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private InputView() { }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String printScanNumberMessage() {
        System.out.print(SCAN_NUMBER_MESSAGE);
        String inputNumbers = Console.readLine();
        InputValidator.validateInputNumbers(inputNumbers);
        return inputNumbers;
    }

    public boolean askKeepPlaying() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equals("1");
    }
}
