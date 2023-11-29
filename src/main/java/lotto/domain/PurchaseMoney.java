package lotto.domain;

public class PurchaseMoney {

    private static final int PURCHASE_MONEY_RANGE_MIN = 1000;
    private static final int PURCHASE_MONEY_UNIT = 1000;
    private static final int ZERO = 0;
    private static final String PURCHASE_MONEY_RANGE_ERROR_MESSAGE = "[ERROR] 구매 금액은 1000원 이상입니다.";
    private static final String PURCHASE_MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구매 금액의 단위는 1000원입니다.";

    private final int purchaseMoney;

    public PurchaseMoney(int purchaseMoney) {
        validateRange(purchaseMoney);
        validateUnit(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validateRange(int purchaseMoney) {
        if (purchaseMoney < PURCHASE_MONEY_RANGE_MIN) {
            throw new IllegalArgumentException(PURCHASE_MONEY_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateUnit(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_MONEY_UNIT != ZERO) {
            throw new IllegalArgumentException(PURCHASE_MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    public int getPurchaseCount() {
        return purchaseMoney / PURCHASE_MONEY_UNIT;
    }
}
