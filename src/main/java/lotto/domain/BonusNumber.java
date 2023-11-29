package lotto.domain;

public class BonusNumber {

    private static final int BONUS_NUMBER_RANGE_MAX = 45;
    private static final int BONUS_NUMBER_RANGE_MIN = 1;
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > BONUS_NUMBER_RANGE_MAX || bonusNumber < BONUS_NUMBER_RANGE_MIN) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
