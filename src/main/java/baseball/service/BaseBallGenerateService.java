package baseball.service;

import baseball.domain.BaseBallNumbers;
import baseball.domain.BaseBallNumbersFactory;
import baseball.view.dto.request.PlayerBaseBallRequest;

public class BaseBallGenerateService {

    private final BaseBallNumbersFactory baseBallNumbersFactory;

    public BaseBallGenerateService(BaseBallNumbersFactory baseBallNumbersFactory) {
        this.baseBallNumbersFactory = baseBallNumbersFactory;
    }

    public BaseBallNumbers createPlayerBaseBallNumbers(PlayerBaseBallRequest playerBaseBallNumber) {
        return baseBallNumbersFactory.generateBaseBallNumbers(playerBaseBallNumber);
    }
}
