package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_LottoAndBonusNumberDuplicate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .withMessageContaining("[ERROR]");
    }
}
