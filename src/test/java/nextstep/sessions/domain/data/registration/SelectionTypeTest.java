package nextstep.sessions.domain.data.registration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectionTypeTest {

    @Test
    void valueOfCode() {
        assertThat(SelectionType.valueOfCode("Y")).isEqualTo(SelectionType.SELECTION);
        assertThat(SelectionType.valueOfCode("N")).isEqualTo(SelectionType.BEFORE_SELECTION);
    }
}