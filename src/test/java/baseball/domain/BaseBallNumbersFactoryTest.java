package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumbersFactoryTest {

    private final BaseBallNumbersFactory baseBallNumbersFactory = new BaseBallNumbersFactory();

    @ParameterizedTest
    @MethodSource("generateBaseBallNumbersForTest")
    void generateBaseBallNumbers메서드는_String형태의_사용자_야구예측번호를_BaseBallNumbers로_응답한다(String baseBallNumber) {
        BaseBallNumbers playerBaseBallNumbers = baseBallNumbersFactory.generateBaseBallNumbers(baseBallNumber);

        assertThat(playerBaseBallNumbers)
                .isInstanceOf(BaseBallNumbers.class);
    }

    @ParameterizedTest
    @MethodSource("generateNotBaseBallNumbersLengthForTest")
    void generateBaseBallNumbers메서드는_3자리가_아닌_사용자_야구예측번호를_입력하면_Exception을_반환한다(String baseBallNumbers) {
        assertThatThrownBy(() -> baseBallNumbersFactory.generateBaseBallNumbers(baseBallNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateBaseBallNumbers메서드는_1_9_사이의_숫자가_아닌_사용자_야구예측번호를_입력하면_Exception을_반환한다() {
        String baseBallNumbers = "019";
        assertThatThrownBy(() -> baseBallNumbersFactory.generateBaseBallNumbers(baseBallNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateBaseBallNumbers메서드는_중복된_숫자를_가진_사용자_야구예측번호를_입력하면_Exception을_반환한다() {
        String baseBallNumbers = "112";
        assertThatThrownBy(() -> baseBallNumbersFactory.generateBaseBallNumbers(baseBallNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> generateBaseBallNumbersForTest() {
        return Stream.of(
                "123",
                "456",
                "789"
        );
    }

    private static Stream<String> generateNotBaseBallNumbersLengthForTest() {
        return Stream.of(
                "12",
                "1234",
                "12345"
        );
    }
}