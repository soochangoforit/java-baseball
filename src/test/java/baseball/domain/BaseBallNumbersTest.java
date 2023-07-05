package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumbersTest {

    @Test
    void _생성자를_통해서_BaseBallNumbers을_생성하는_경우_중복된_BallBallNumber을_허용하지_않는다() {
        assertThatThrownBy(() -> new BaseBallNumbers(1, 1, 2))
                .isInstanceOf(BaseBallGameException.class);
    }

}