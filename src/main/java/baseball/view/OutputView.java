package baseball.view;

import baseball.domain.BaseBallGameResult;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private OutputView() { }

    public void printGameResult(BaseBallGameResult gameResult) {
        if (gameResult.hasNothing()) {
            System.out.println("낫싱");
            return;
        }

        if (gameResult.hasBall() && gameResult.hasStrike()) {
            int ballCount = gameResult.getBallCount();
            int strikeCount = gameResult.getStrikeCount();
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
            return;
        }

        if (gameResult.hasBall() && !gameResult.hasStrike()) {
            int ballCount = gameResult.getBallCount();
            System.out.printf("%d볼\n", ballCount);
            return;
        }
        if (gameResult.hasStrike() && !gameResult.hasBall()) {
            int strikeCount = gameResult.getStrikeCount();
            System.out.printf("%d스트라이크\n", strikeCount);
            if (gameResult.hasAllStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }


    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }


}
