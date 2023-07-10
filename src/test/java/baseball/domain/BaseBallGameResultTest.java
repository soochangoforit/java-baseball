package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BaseBallGameResultTest {

    @Test
    void hasBall메서드는_볼을_가지고_있는_경우_true를_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(1, 1);

        assertTrue(baseBallGameResult.hasBall());
    }

    @Test
    void hasBall메서드는_볼을_가지고_있지_않는_경우_false을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(1, 0);

        assertFalse(baseBallGameResult.hasBall());
    }


    @Test
    void hasStrike메서드는_스트라이크을_가지고_있는_경우_true을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(1, 1);

        assertTrue(baseBallGameResult.hasStrike());
    }

    @Test
    void hasStrike메서드는_스트라이크을_가지고_있지_않는_경우_true을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(0, 1);

        assertFalse(baseBallGameResult.hasStrike());
    }

    @Test
    void hasNothing메서드는_볼과스트라이크_그_어느것도_가지지_않는_경우_true을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(0, 0);

        assertTrue(baseBallGameResult.hasNothing());
    }

    @Test
    void hasNothing메서드는_볼과스트라이크_하나라도_가지는_경우_true을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(1, 0);

        assertFalse(baseBallGameResult.hasNothing());
    }

    @Test
    void hasAllStrike메서드는_3개의_스트라이크를_가지는_경우_true을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(3, 0);

        assertTrue(baseBallGameResult.hasAllStrike());
    }

    @Test
    void hasAllStrike메서드는_3개의_스트라이크를_가지지_않는_경우_false을_응답한다() {
        BaseBallGameResult baseBallGameResult = new BaseBallGameResult(2, 0);

        assertFalse(baseBallGameResult.hasAllStrike());
    }
}
