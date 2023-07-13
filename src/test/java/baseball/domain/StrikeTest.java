package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void isThreeStrike메서드는_3스트라이크가_아닌_경우_false을_응답한다() {
        Strike strike = Strike.TWO;

        assertFalse(strike.isThreeStrike());
    }

    @Test
    void hasStrike메서드는_스타라이크가_없는_경우_false를_응답한다() {
        Strike strike = Strike.NONE;

        assertFalse(strike.hasStrike());
    }

    @ParameterizedTest
    @CsvSource({
            "true, ONE",
            "true, TWO",
            "true, THREE",
    })
    void hasStrike메서드는_스타라이크가_있는_경우_true를_응답한다(boolean expected, Strike strike) {
        assertEquals(expected, strike.hasStrike());
    }
}
