package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseBallNumberFactoryTest {

    private final BaseBallNumberFactory baseBallNumberFactory = new BaseBallNumberFactory();

    // TODO : 새로운 Test Code 연습, ParameterizedTest aseertThat().allSatisfy()
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void generate메서드는_String_입력값이_들어오는_경우_협력에_필요한_타입으로_변환한다(String playerBaseBallNumber) {
        List<Integer> baseBallNumbers = baseBallNumberFactory.generate(playerBaseBallNumber);

        assertThat(baseBallNumbers).hasSize(3);
        assertThat(baseBallNumbers).allSatisfy(number -> assertThat(number).isInstanceOf(Integer.class));
    }
}