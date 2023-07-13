package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberTest {


    @ParameterizedTest(name = "BaseBallNumber는 {0}을 입력받으면 Exception을 반환한다")
    @ValueSource(ints = {0, 10})
    void BaseBallNumber는_1에서_9사이_숫자가_아니면_Exception_반환(int baseBallNumber) {
        assertThatThrownBy(() -> new BaseBallNumber(baseBallNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "BaseBallNumber는 {0}을 입력받으면 Exception을 반환하지 않는다")
    @ValueSource(ints = {1, 9})
    void BaseBallNumber는_1에서_9사이_숫자면_Exception_반환하지_않는다(int baseBallNumber) {
        assertDoesNotThrow(() -> new BaseBallNumber(baseBallNumber));
    }


    @Test
    void generateRandom메서드는_generator로부터_반환된_숫자로_BaseBallNumber를_생성한다() {
        NumberGenerator numberGenerator = (a, b) -> 1;
        BaseBallNumber baseBallNumber = BaseBallNumber.generateRandom(numberGenerator);
        assertEquals(new BaseBallNumber(1), baseBallNumber);
    }


}
