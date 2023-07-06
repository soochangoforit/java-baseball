package baseball.domain;


public enum BaseBallGameStatus {
    END(false),
    CONTINUE(true);

    private final boolean status;

    BaseBallGameStatus(boolean status) {
        this.status = status;
    }

    public boolean isNotEnd() {
        return this == END;
    }
}
