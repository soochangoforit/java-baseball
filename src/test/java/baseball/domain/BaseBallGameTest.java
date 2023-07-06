package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseBallGameTest {

    @Test
    void play메서드는_사용자가_3개_모두_맞춘경우_3_strike상태를_갖는_result을_응답한다() {
        BaseBallNumbers randomNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers playerNumbers = new BaseBallNumbers(1, 2, 3);

        BaseBallGame baseBallGame = new BaseBallGame(randomNumbers);
        GameResult result = baseBallGame.play(playerNumbers);

        assertThat(result).isEqualTo(new GameResult(3, 0));
    }

    @Test
    void play메서드는_사용자가_3개_모두_맞춘경우_게임상태를_끝남으로_변경한다() {
        BaseBallNumbers randomNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers playerNumbers = new BaseBallNumbers(1, 2, 3);

        BaseBallGame baseBallGame = new BaseBallGame(randomNumbers);
        baseBallGame.play(playerNumbers);

        assertThat(baseBallGame.isNotEnd()).isFalse();
    }

}