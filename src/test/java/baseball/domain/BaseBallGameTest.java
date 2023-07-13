package baseball.domain;

import static baseball.domain.Ball.NONE;
import static baseball.domain.Strike.THREE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class BaseBallGameTest {


    @Test
    void startGame메서드는_게임을_진행하고_모두_맞춘경우_3스타라이크_결과를_반환한다() {
        BaseBallGame baseBallGame = BaseBallGame.initializeGame(new BaseBallNumbers(1, 2, 3));

        BaseBallGameResult baseBallGameResult = baseBallGame.startGame(new BaseBallNumbers(1, 2, 3));

        Assertions.assertThat(baseBallGameResult).isEqualTo(new BaseBallGameResult(THREE, NONE));
    }


}
