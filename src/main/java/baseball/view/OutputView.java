package baseball.view;

public class OutputView {

    private OutputView() { }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }


    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SCAN_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printScanNumberMessage() {
        System.out.println(SCAN_NUMBER_MESSAGE);
    }

}
