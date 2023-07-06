package baseball.view;

import baseball.domain.GameResult;

public class OutputView {

    private OutputView() { }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameResult(GameResult result) {
        StringBuilder resultMessage = new StringBuilder();

        if(result.strikeCount() > 0) {
            resultMessage.append(result.strikeCount()).append("스트라이크 ");
        }
        if(result.ballCount() > 0) {
            resultMessage.append(result.ballCount()).append("볼");
        }

        if(result.strikeCount() == 0 && result.ballCount() == 0) {
            resultMessage.append("낫싱");
        }

        System.out.println(resultMessage);
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }


    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }


}
