package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

    @ParameterizedTest
    @CsvSource({
            "0, NONE",
            "1, ONE",
            "2, TWO",
            "3, THREE"
    })
    void from메서드는_숫자에_해당하는_Ball을_반환한다(int number, Ball expected) {
        assertEquals(expected, Ball.from(number));
    }

    @Test
    void from메서드는_올바르지_못한_입력이_들어오는_경우_Exception응답한다() {
        int invalidNumber = 4;

        assertThatThrownBy(() -> Ball.from(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "true, ONE",
            "true, TWO",
            "true, THREE",
    })
    void hasBall메서드는_볼이_있는_경우_true를_응답한다(boolean expected, Ball ball) {
        assertEquals(expected, ball.hasBall());
    }


}
