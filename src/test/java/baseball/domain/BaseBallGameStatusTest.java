package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class BaseBallGameStatusTest {

    @Test
    void BaseBallGameStatus가_FINISH인_경우는_게임종료가_true이다() {
        Assertions.assertThat(BaseBallGameStatus.FINISH.isFinished())
                .isTrue();
    }

    @Test
    void BaseBallGameStatus가_NOT_FINISH인_경우는_게임종료가_false이다() {
        Assertions.assertThat(BaseBallGameStatus.NOT_FINISH.isFinished())
                .isFalse();
    }

}