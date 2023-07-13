package baseball.view;

import baseball.domain.BaseBallGameResult;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String BALL_ONLY_MESSAGE = "%d볼\n";
    private static final String STRIKE_ONLY_MESSAGE = "%d스트라이크\n";
    private static final String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private OutputView() {
    }

    public void printGameResult(BaseBallGameResult gameResult) {
        if (gameResult.hasNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        if (gameResult.hasBall() && gameResult.hasStrike()) {
            int ballCount = gameResult.getBallCount();
            int strikeCount = gameResult.getStrikeCount();
            System.out.printf(BALL_AND_STRIKE_MESSAGE, ballCount, strikeCount);
            return;
        }

        if (gameResult.hasBall() && !gameResult.hasStrike()) {
            int ballCount = gameResult.getBallCount();
            System.out.printf(BALL_ONLY_MESSAGE, ballCount);
            return;
        }

        if (gameResult.hasStrike() && !gameResult.hasBall()) {
            int strikeCount = gameResult.getStrikeCount();
            System.out.printf(STRIKE_ONLY_MESSAGE, strikeCount);

            if (gameResult.hasAllStrike()) {
                System.out.println(ALL_STRIKE_MESSAGE);
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
