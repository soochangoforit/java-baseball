package baseball.domain;

import static baseball.domain.Ball.NONE;
import static baseball.domain.Strike.THREE;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class BaseBallGameTest {

    @Test
    void initializeGame메서드로_BaseBallGame을_생성하는_경우_기본_게임상태는_NOT_FINISH이다() {
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(new BaseBallNumbers(1, 2, 3));

        assertThat(baseBallGame.isFinished()).isFalse();
    }

    @Test
    void startGame메서드는_게임을_진행하고_모두_맞춘경우_3스타라이크_결과를_반환한다() {
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(new BaseBallNumbers(1, 2, 3));

        BaseBallGameResult baseBallGameResult = baseBallGame.startGame(new BaseBallNumbers(1, 2, 3));

        Assertions.assertThat(baseBallGameResult).isEqualTo(new BaseBallGameResult(THREE, NONE));
    }

    @Test
    void startGame메서드는_게임을_진행하고_모두_맞춘_경우_종료상태가_된다() {
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(new BaseBallNumbers(1, 2, 3));

        baseBallGame.startGame(new BaseBallNumbers(1, 2, 3));

        assertThat(baseBallGame.isFinished()).isTrue();
    }

    @Test
    void isNotFinished메서드는_2스트라이크라서_아직_끝나지_않은_경우라면_true를_반환한다() {
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(new BaseBallNumbers(1, 2, 3));

        baseBallGame.startGame(new BaseBallNumbers(1, 2, 4));

        assertThat(baseBallGame.isNotFinished()).isTrue();
    }
  

}
