package baseball.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private final Generator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void _generateRandomNumber은_1_9사이의_숫자를_반환한다() {
        int randomNumber = randomNumberGenerator.generateRandomNumber();

        assertThat(randomNumber).isBetween(1, 9);
    }

    // TODO : 새롭게 배운 doesNotHaveDuplicates()
}