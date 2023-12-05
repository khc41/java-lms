package nextstep.courses.domain.repository;

import java.util.List;

public interface CourseSessionRepository {
    int save(Long courseId, Long sessionId);

    List<Integer> findByCourseId(Long courseId);

    int findBySessionId(Long sessionId);
}