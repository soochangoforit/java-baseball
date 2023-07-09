package baseball.view.dto.request;


public class PlayerBaseBallRequest {

    private static final String NUMBER_REGEX = "\\d+";

    private final String playerBaseBallNumber;

    public PlayerBaseBallRequest(final String playerBaseBallNumber) {
        validatePlayerBaseBallNumber(playerBaseBallNumber);
        this.playerBaseBallNumber = playerBaseBallNumber;
    }

    public String baseBallNumber() {
        return playerBaseBallNumber;
    }

    private void validatePlayerBaseBallNumber(final String playerBaseBallNumber) {
        if (!isNumber(playerBaseBallNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(final String playerBaseBallNumber) {
        return playerBaseBallNumber.matches(NUMBER_REGEX);
    }




}
