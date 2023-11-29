package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Nested
    class Range {

        @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
        @Test
        void should_ThrowException_When_UnderOne() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
        @Test
        void should_ThrowException_When_OverFortyFive() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                    .withMessageContaining("[ERROR]");
        }
    }

}