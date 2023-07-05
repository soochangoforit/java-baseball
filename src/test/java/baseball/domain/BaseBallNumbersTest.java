package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseBallNumbersTest {

    @Test
    void _생성자를_통해서_BaseBallNumbers을_생성하는_경우_중복된_BallBallNumber을_허용하지_않는다() {
        assertThatThrownBy(() -> new BaseBallNumbers(1, 1, 2))
                .isInstanceOf(BaseBallGameException.class);
    }

    @Test
    void _play메서드는_3개숫자를_모두_맞춘경우_3스트라이크를_반환한다() {
        BaseBallNumbers randomBaseBallNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(1, 2, 3);

        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);

        assertThat(result).isEqualTo(new GameResult(3, 0));
    }

    @Test
    void _play메서드는_3개숫자를_모두_틀린경우_낫띵을_반환한다() {
        BaseBallNumbers randomBaseBallNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(4, 5, 6);

        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);

        assertThat(result).isEqualTo(new GameResult(0, 0));
    }

    @Test
    void _play메서드는_3개숫자중_1개의숫자_위치를_맞춘경우_1볼을_반환한다() {
        BaseBallNumbers randomBaseBallNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(3, 4, 5);

        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);

        assertThat(result).isEqualTo(new GameResult(0, 1));
    }

    @Test
    void _play메서드는_3개숫자중_1개를_맞추고_1개의_위치만_맞춘경우_1스트라이크_1볼을_반환한다() {
        BaseBallNumbers randomBaseBallNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(1, 3, 4);

        GameResult result = randomBaseBallNumbers.play(playerBaseBallNumbers);

        assertThat(result).isEqualTo(new GameResult(1, 1));
    }

}