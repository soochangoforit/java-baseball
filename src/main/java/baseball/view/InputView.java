package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() { }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();
    }


    private static final String SCAN_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public String printScanNumberMessage() {
        System.out.print(SCAN_NUMBER_MESSAGE);
        String inputNumbers = Console.readLine();
        InputValidator.validateInputNumbers(inputNumbers);
        return inputNumbers;
    }


}
