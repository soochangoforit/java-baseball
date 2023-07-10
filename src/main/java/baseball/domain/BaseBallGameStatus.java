package baseball.domain;

public enum BaseBallGameStatus {

    FINISH(true),
    NOT_FINISH(false);

    private final boolean isFinished;

    BaseBallGameStatus(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
