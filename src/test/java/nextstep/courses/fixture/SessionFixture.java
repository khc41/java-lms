package nextstep.courses.fixture;

import nextstep.courses.domain.*;

import java.time.LocalDateTime;

public class SessionFixture {
    public static Session create(SessionStatus sessionStatus, int maximumUserCount) {
        LocalDateTime startedAt = LocalDateTime.now();
        LocalDateTime endAt = startedAt.plusMonths(1);

        return new Session(1L, new SessionPeriod(startedAt, endAt), PaymentType.PAID, sessionStatus, maximumUserCount);
    }
}
