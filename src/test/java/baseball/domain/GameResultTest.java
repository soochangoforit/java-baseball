package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    @Test
    void isAllStrike메서드는_모두_스트라이크_경우에는_true을_응답한다() {
        GameResult gameResult = new GameResult(3, 0);

        assertThat(gameResult.isAllStrike()).isTrue();
    }

    @Test
    void isAllStrike메서드는_모두_스트라이크가_아닌_경우에는_false을_응답한다() {
        GameResult gameResult = new GameResult(2, 0);

        assertThat(gameResult.isAllStrike()).isFalse();
    }
}