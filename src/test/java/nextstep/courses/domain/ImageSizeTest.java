package nextstep.courses.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImageSizeTest {

    public static final ImageSize is1 = new ImageSize(400, 300);

    @Test
    @DisplayName("이미지의 세로 길이가 200pixel 아래일 경우, 예외를 발생시킨다.")
    void 이미지_세로_체크() {
        Assertions.assertThatThrownBy(() -> new ImageSize(300, 199))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이미지의 가로 길이가 300pixel 아래일 경우, 예외를 발생시킨다.")
    void 이미지_가로_체크() {
        Assertions.assertThatThrownBy(() -> new ImageSize(299, 200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}