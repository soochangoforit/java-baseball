package baseball.view.dto.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PlayerBaseBallRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "d12", "g"})
    void PlayerBaseBallRequest생성자에서는_숫자가_아닌_문자열이_오면_Exception을_응답한다(String playerBaseBallNumber) {
        assertThatThrownBy(() -> new PlayerBaseBallRequest(playerBaseBallNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void PlayerBaseBallRequest생성자에서는_입력이_모두_숫자인_경우는_정상흐름으로_판단한다(String playerBaseBallNumber) {
        Assertions.assertDoesNotThrow(() -> new PlayerBaseBallRequest(playerBaseBallNumber));
    }

}