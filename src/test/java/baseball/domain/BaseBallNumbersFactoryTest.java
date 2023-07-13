package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.view.dto.request.PlayerBaseBallRequest;

class BaseBallNumbersFactoryTest {

    private final BaseBallNumbersFactory baseBallNumbersFactory = new BaseBallNumbersFactory();
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @ParameterizedTest
    @MethodSource("generateBaseBallNumbersForTest")
    void createPlayerBaseBallNumbers메서드는_String형태의_사용자_야구예측번호를_BaseBallNumbers로_응답한다(String baseBallNumber) {
        PlayerBaseBallRequest playerBaseBallRequest = new PlayerBaseBallRequest(baseBallNumber);
        BaseBallNumbers playerBaseBallNumbers = baseBallNumbersFactory.createPlayerBaseBallNumbers(playerBaseBallRequest);

        assertThat(playerBaseBallNumbers)
                .isInstanceOf(BaseBallNumbers.class);
    }

    @ParameterizedTest
    @MethodSource("generateNotBaseBallNumbersLengthForTest")
    void createPlayerBaseBallNumbers메서드는_3자리가_아닌_사용자_야구예측번호를_입력하면_Exception을_반환한다(String baseBallNumbers) {
        PlayerBaseBallRequest playerBaseBallRequest = new PlayerBaseBallRequest(baseBallNumbers);
        assertThatThrownBy(() -> baseBallNumbersFactory.createPlayerBaseBallNumbers(playerBaseBallRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createPlayerBaseBallNumbers메서드는_1_9_사이의_숫자가_아닌_사용자_야구예측번호를_입력하면_Exception을_반환한다() {
        PlayerBaseBallRequest playerBaseBallRequest = new PlayerBaseBallRequest("019");
        assertThatThrownBy(() -> baseBallNumbersFactory.createPlayerBaseBallNumbers(playerBaseBallRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createPlayerBaseBallNumbers메서드는_중복된_숫자를_가진_사용자_야구예측번호를_입력하면_Exception을_반환한다() {
        PlayerBaseBallRequest playerBaseBallRequest = new PlayerBaseBallRequest("112");
        assertThatThrownBy(() -> baseBallNumbersFactory.createPlayerBaseBallNumbers(playerBaseBallRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createRandomBaseBallNumbers메서드는_랜덤으로_생성된_숫자를_가진_BaseBallNumbers를_응답한다() {
        BaseBallNumbers randomBaseBallNumbers = baseBallNumbersFactory.createRandomBaseBallNumbers(randomNumberGenerator);
        assertThat(randomBaseBallNumbers)
                .isInstanceOf(BaseBallNumbers.class);
    }

    @Test
    void createRandomBaseBallNumbers메서드는_1_9_사이의_숫자가_아닌_경우_Exception을_반환한다() {
        NumberGenerator numberGenerator = (a, b) -> 10;
        assertThatThrownBy(() -> baseBallNumbersFactory.createRandomBaseBallNumbers(numberGenerator))
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
