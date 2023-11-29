package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private static final String LOTTO_AND_BONUS_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lotto lotto;
    private final BonusNumber bonusNumber;
    private final WinningResult winningResult;

    public WinningNumbers(Lotto lotto, BonusNumber bonusNumber, WinningResult winningResult) {
        validateDuplicate(lotto.getNumbers(), bonusNumber.getNumber());
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.winningResult = winningResult;
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_AND_BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void compareWithTicket(List<Integer> ticket) {
        int matchingCount = 0;
        boolean hasMatchingBonusNumber = false;
        for (int number : ticket) {
            if (lotto.getNumbers().contains(number)) {
                matchingCount++;
            }
            if (bonusNumber.getNumber() == number) {
                hasMatchingBonusNumber = true;
            }
        }
        winningResult.judgeRank(matchingCount, hasMatchingBonusNumber);
    }
}
