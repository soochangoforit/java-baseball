package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private final Generator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void _generateRandomNumber은_BaseBallNumbers_타입을_반환한다() {
        BaseBallNumbers randomNumbers = randomNumberGenerator.generateRandomNumber();

        assertThat(randomNumbers.size()).isEqualTo(3);
        assertThat(randomNumbers).isInstanceOf(BaseBallNumbers.class);
    }

    // TODO : 새롭게 배운 doesNotHaveDuplicates()
}