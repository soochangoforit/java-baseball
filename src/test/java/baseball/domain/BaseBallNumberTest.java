package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseBallNumberTest {

    // TODO : 어떠한 범위 값을 test 할때는 범위 경계 부분에 대해서 테스트를 해야한다.
    @Test
    void _BaseBallNumber는_1에서_9까지의_숫자만_허용한다() {
        assertThatThrownBy(() -> new BaseBallNumber(0))
                .isInstanceOf(BaseBallGameException.class);

        assertThatThrownBy(() -> new BaseBallNumber(10))
                .isInstanceOf(BaseBallGameException.class);
    }

    @Test
    void equals메서드는_같은_숫자인지_확인한다() {
        BaseBallNumber baseBallNumber = new BaseBallNumber(1);

        assertThat(baseBallNumber.equals(new BaseBallNumber(1))).isTrue();
        assertThat(baseBallNumber.equals(new BaseBallNumber(2))).isFalse();
    }


}