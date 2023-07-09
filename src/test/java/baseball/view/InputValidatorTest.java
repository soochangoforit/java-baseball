package baseball.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "12", "1234", "12345"})
    void validatePlayerBaseBallNumber메서드는_입력값의_길이가_3과_맞지_않으면_Exception반환(String playNumbers) {
        assertThatThrownBy(() -> InputValidator.validatePlayerBaseBallNumber(playNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void validatePlayerBaseBallNumber메서드는_입력값의_길이가_3과_맞으면_입력값을_반환하지_않는다(String playNumbers) {
        assertDoesNotThrow(() -> InputValidator.validatePlayerBaseBallNumber(playNumbers));
    }
}