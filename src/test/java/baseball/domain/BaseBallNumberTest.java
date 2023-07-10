package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void BaseBallNumber는_1에서_9사이_숫자가_아니면_Exception_반환(int baseBallNumber) {
        assertThatThrownBy(() -> new BaseBallNumber(baseBallNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void BaseBallNumber는_1에서_9사이_숫자면_Exception_반환하지_않는다(int baseBallNumber) {
        assertDoesNotThrow(() -> new BaseBallNumber(baseBallNumber));
    }


}
