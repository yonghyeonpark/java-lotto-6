package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final String LOTTO_AND_BONUS_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateDuplicate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_AND_BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
