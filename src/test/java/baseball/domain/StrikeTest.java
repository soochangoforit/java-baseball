package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrikeTest {

    @ParameterizedTest
    @CsvSource({
            "0, NONE",
            "1, ONE",
            "2, TWO",
            "3, THREE"
    })
    void from메서드는_숫자에_해당하는_Strike를_반환한다(int number, Strike expected) {
        assertEquals(expected, Strike.from(number));
    }

    @Test
    void from메서드는_올바르지_못한_입력이_들어오는_경우_Exception응답한다() {
        int invalidNumber = 4;

        assertThatThrownBy(() -> Strike.from(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isThreeStrike메서드는_3스트라이크인_경우_true을_응답한다() {
        Strike strike = Strike.THREE;

        assertTrue(strike.isThreeStrike());
    }



    @ParameterizedTest
    @CsvSource({
            "true, ONE",
            "true, TWO",
            "true, THREE",
    })
    void hasStrike메서드는_볼이_있는_경우_true를_응답한다(boolean expected, Strike strike) {
        assertEquals(expected, strike.hasStrike());
    }
}