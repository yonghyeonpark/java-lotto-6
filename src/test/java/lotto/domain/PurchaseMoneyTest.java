package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseMoneyTest {

    @DisplayName("구매 금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_PurchaseMoneyOutOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseMoney(999))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("구매 금액의 단위가 1000이 아니면 예외가 발생한다.")
    @Test
    void should_ThrowException_When_PurchaseMoneyUnitWrong() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseMoney(1500))
                .withMessageContaining("[ERROR]");
    }
}
