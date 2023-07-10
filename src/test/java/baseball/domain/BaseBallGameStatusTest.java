package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class BaseBallGameStatusTest {
    
    @Test
    void isFinished메서드는_상태가_FINISH인_경우_true를_반환한다() {
        assertThat(BaseBallGameStatus.FINISH.isFinished())
                .isTrue();
    }

    @Test
    void isFinished메서드는_상태가_NOT_FINISH인_경우_false를_반환한다() {
        assertThat(BaseBallGameStatus.NOT_FINISH.isFinished())
                .isFalse();
    }

}
