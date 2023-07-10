package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.domain.BaseBallGameStatus.NOT_FINISH;
import static org.assertj.core.api.Assertions.assertThat;


class BaseBallGameTest {

    @Test
    void initializeGame메서드로_BaseBallGame을_생성하는_경우_기본_게임상태는_NOT_FINISH이다() {
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(new BaseBallNumbers(1,2,3));

        assertThat(baseBallGame.isFinished()).isEqualTo(false);
    }


}