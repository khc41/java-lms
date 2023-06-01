package nextstep.courses.domain;

import nextstep.users.domain.NsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enrollment {
    private final SessionStatus sessionStatus;

    private final int capacity;

    private final Students students;

    public Enrollment(SessionStatus sessionStatus, int capacity) {
        this(sessionStatus, capacity, new ArrayList<>());
    }

    public Enrollment(SessionStatus sessionStatus, int capacity, List<NsUser> students) {
        this.sessionStatus = sessionStatus;
        this.capacity = capacity;
        this.students = new Students(capacity, students);
    }

    public void enroll(NsUser student) throws AlreadyEnrollmentException {
        if (!sessionStatus.isEnrolling()) {
            throw new IllegalArgumentException("수강신청 상태가 아니라 수강신청할 수 없습니다.");
        }
        students.enroll(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return capacity == that.capacity && sessionStatus == that.sessionStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, sessionStatus);
    }
}