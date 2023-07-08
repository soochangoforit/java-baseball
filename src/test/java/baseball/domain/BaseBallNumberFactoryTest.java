package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

class BaseBallNumberFactoryTest {

    private final BaseBallNumberFactory baseBallNumberFactory = new BaseBallNumberFactory();
    private final Generator generator = new RandomNumberGenerator();

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void generate메서드는_String_입력값이_들어오는_경우_협력에_필요한_타입으로_변환한다(String playerBaseBallNumber) {
        BaseBallNumbers baseBallNumbers = baseBallNumberFactory.generate(playerBaseBallNumber);

        assertThat(baseBallNumbers.size()).isEqualTo(3);
        assertThat(baseBallNumbers.numbers())
                .allSatisfy(baseBallNumber -> {
            assertThat(baseBallNumber).isInstanceOf(BaseBallNumber.class);
        });
    }

    @Test
    void _generateRandomNumber메서드는_3개의_숫자를_생성한다() {
        BaseBallNumbers randomNumbers = baseBallNumberFactory.generateRandomNumber(generator);

        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void _generateRandomNumber메서드는_중복되지_않는_숫자를_생성한다() {
        BaseBallNumbers randomNumbers = baseBallNumberFactory.generateRandomNumber(generator);

        assertThat(randomNumbers.numbers()).doesNotHaveDuplicates();
    }

    @Test
    void _generateRandomNumber메서드는_1에서_9까지의_숫자를_생성한다() {
        BaseBallNumbers randomNumbers = baseBallNumberFactory.generateRandomNumber(generator);

        assertThat(randomNumbers.numbers())
                .allSatisfy(baseBallNumber -> {
                    assertThat(baseBallNumber.number()).isBetween(1, 9);
                });
    }

}