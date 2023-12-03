package nextstep.courses.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class SessionImageTest {

    private Path workingDir;
    @BeforeEach
    void setUp() {
        this.workingDir = Path.of("", "src/test/resources");
    }

    private URI getUri(String fileName) {
        return workingDir.resolve(fileName).toUri();
    }

    @Test
    void 이미지는_1MB이하여야한다() {
        File file = new File(getUri("test_2mb.jpg"));
        assertThatThrownBy(() -> {
            new SessionImage(file);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이미지는_이미지형식외의_파일은_불가능하다() {
        File file = new File(getUri("test.txt"));
        assertThatThrownBy(() -> {
            new SessionImage(file);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}