package nextstep.courses.domain.session.enrollment.count;

public class RegistrationCount {

    private int value;

    public RegistrationCount(int value) {
        this.value = value;
    }

    public int addValue() {
        return ++value;
    }

    public boolean isValueZero() {
        return value == 0;
    }

    public int getValue() {
        return value;
    }
}