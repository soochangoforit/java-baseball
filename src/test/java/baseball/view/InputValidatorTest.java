package baseball.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class InputValidatorTest {

    @Test
    void validateInputNumbers메서드는_숫자범위가_1와_9사이의_값이_아니면_Exception_응답한다() {
        String inputNumber = "012";

        assertThatThrownBy(() -> InputValidator.validateInputNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputNumbers메서드는_숫자가_3자리가_아니면_Exception_응답한다() {
        String inputNumber = "1234";

        assertThatThrownBy(() -> InputValidator.validateInputNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputNumbers메서드는_숫자가_중복되면_Exception_응답한다() {
        String inputNumber = "112";

        assertThatThrownBy(() -> InputValidator.validateInputNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputNumbers메서드는_숫자가_아니면_Exception_응답한다() {
        String inputNumber = "abc";

        assertThatThrownBy(() -> InputValidator.validateInputNumbers(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}