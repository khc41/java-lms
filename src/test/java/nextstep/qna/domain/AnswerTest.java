package nextstep.qna.domain;

import nextstep.qna.CannotDeleteException;
import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnswerTest {
    public static final Answer A1 = new Answer(NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1");
    public static final Answer A2 = new Answer(NsUserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

    @Test
    @DisplayName("Answer 정상 삭제")
    void deleteNormal() {
        //given when
        Assertions.assertDoesNotThrow(() -> {
            A1.delete(NsUserTest.JAVAJIGI);
        });

        //then
        assertThat(A1.isDeleted()).isEqualTo(true);
    }

    @Test
    @DisplayName("Answer 삭제 테스트 에러 발생")
    void deleteError() {
        Assertions.assertThrows(CannotDeleteException.class, () -> {
            A1.delete(NsUserTest.SANJIGI);
        });
    }
}
