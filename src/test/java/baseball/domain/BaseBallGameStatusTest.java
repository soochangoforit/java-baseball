package baseball.domain;

import org.junit.jupiter.api.Test;

import static baseball.domain.BaseBallGameStatus.CONTINUE;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameStatusTest {

    @Test
    void isNotEnd메서드는_Status_상태가_CONTINUE_일때_TRUE을_응답한다() {
        assertTrue(CONTINUE.isNotEnd());
    }
}