package nextstep.qna.domain;

import nextstep.qna.UnAuthorizedException;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnswersTest {
    public static final Question Q1 = new Question(NsUserTest.JAVAJIGI, "title1", "contents1");
    public static final Answers AS1 = new Answers(Q1);

    @Test
    public void deleteAll_success() {
        // given
        Answer A1 = new Answer(NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents2");
        Answer A2 = new Answer(NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents2");

        AS1.addAnswer(A1);
        AS1.addAnswer(A2);

        // when
        AS1.deleteAll(NsUserTest.JAVAJIGI);

        // then
        assertThat(A1.isDeleted()).isTrue();
        assertThat(A2.isDeleted()).isTrue();
    }

    @Test
    public void deleteAll_fail() {
        // given
        Answer A1 = new Answer(NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents2");
        Answer A2 = new Answer(NsUserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

        AS1.addAnswer(A1);
        AS1.addAnswer(A2);

        // when & then
        assertThatThrownBy(
                () -> AS1.deleteAll(NsUserTest.JAVAJIGI)
        ).isInstanceOf(UnAuthorizedException.class)
                .hasMessage("답변의 작성자가 아닙니다.");
    }

    @Test
    public void getWriters() {
        // given
        Answer A1 = new Answer(NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents2");
        Answer A2 = new Answer(NsUserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

        AS1.addAnswer(A1);
        AS1.addAnswer(A2);

        // when
        Set<NsUser> writers = AS1.getWriters();

        // then
        assertThat(writers).containsAll(List.of(NsUserTest.JAVAJIGI, NsUserTest.SANJIGI));
    }
}
