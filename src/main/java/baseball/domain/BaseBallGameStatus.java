package baseball.domain;

import java.util.Objects;

public class BaseBallGameStatus {

    private final boolean status;

    public BaseBallGameStatus(boolean status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallGameStatus that = (BaseBallGameStatus) o;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
