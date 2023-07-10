package baseball.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BaseBallGameStatusTest {

    @Test
    void BaseBallGameStatus가_FINISH인_경우는_게임종료가_true이다() {
        assertThat(BaseBallGameStatus.FINISH.isFinished())
                .isTrue();
    }

    @Test
    void BaseBallGameStatus가_NOT_FINISH인_경우는_게임종료가_false이다() {
        assertThat(BaseBallGameStatus.NOT_FINISH.isFinished())
                .isFalse();
    }

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