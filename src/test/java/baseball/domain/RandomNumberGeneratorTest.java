package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void generate메서드는_최소값과_최대값을_지정하면_그사이에_있는값만_만들어준다() {
        int number = randomNumberGenerator.generate();

        assertTrue(number >= 1 && number <= 9);
    }
}
