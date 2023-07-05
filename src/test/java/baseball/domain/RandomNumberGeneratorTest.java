package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    void _1에서_9까지_범위의_중복되지_않는_랜덤_숫자를_발행한다() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumber();

        assertThat(randomNumbers).hasSize(3);
        assertThat(randomNumbers).allMatch(number -> number >= 1 && number <= 9);
    }

    // TODO : 새롭게 배운 doesNotHaveDuplicates()
    @Test
    void _생성된_랜덤한_숫자는_중복되지_않는다() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumber();

        assertThat(randomNumbers).hasSize(3);
        assertThat(randomNumbers).doesNotHaveDuplicates();
    }
}