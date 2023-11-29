package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest(name = "[테스트 케이스 {index}] 보너스 번호 : {arguments}")
    @ValueSource(ints = {0, 46})
    void should_ThrowException_When_BonusNumberOutOfRange(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(bonusNumber))
                .withMessageContaining("[ERROR]");
    }
}
