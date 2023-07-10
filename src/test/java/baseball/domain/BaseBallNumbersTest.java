package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallNumbersTest {

    @ParameterizedTest
    @MethodSource("duplicateBaseBallNumbersForTest")
    void BaseBallNumbers는_중복된_BaseBallNumber을_가지면_Exception_반환한다(int[] numbers) {
        assertThatThrownBy(() -> new BaseBallNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("overSizeBaseBallNumbersForTest")
    void BaseBallNumbers는_3개의_BaseBallNumber를_가지지_않으면_Exception_반환한다(int[] numbers) {
        assertThatThrownBy(() -> new BaseBallNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countStrike메서드는_3개의_숫자와_자리가_일차하는_경우_3을_응답한다() {
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers randomBaseBallNumbers = new BaseBallNumbers(1, 2, 3);

        Strike strike = playerBaseBallNumbers.countStrike(randomBaseBallNumbers);

        assertThat(strike).isEqualTo(Strike.THREE);
    }

    @Test
    void countBall메서드는_3개의_숫자가_같지만_자리가_일치하지_않는_경우_3볼을_응답한다() {
        BaseBallNumbers playerBaseBallNumbers = new BaseBallNumbers(1, 2, 3);
        BaseBallNumbers randomBaseBallNumbers = new BaseBallNumbers(3, 1, 2);

        Strike strikeCount = randomBaseBallNumbers.countStrike(playerBaseBallNumbers);

        Ball ball = randomBaseBallNumbers.countBall(playerBaseBallNumbers, strikeCount);

        assertThat(ball).isEqualTo(Ball.THREE);
    }

    private static Stream<int[]> duplicateBaseBallNumbersForTest() {
        return Stream.of(
                new int[]{1, 1, 2},
                new int[]{1, 2, 2},
                new int[]{1, 2, 1}
        );
    }

    private static Stream<int[]> overSizeBaseBallNumbersForTest() {
        return Stream.of(
                new int[]{1, 2},
                new int[]{1, 2, 3, 4}
        );
    }

}
