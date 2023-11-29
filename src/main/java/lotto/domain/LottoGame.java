package lotto.domain;

import java.util.List;

public class LottoGame {

    private final PurchaseMoney purchaseMoney;
    private final WinningNumbers winningNumbers;
    private final WinningResult winningResult;

    public LottoGame(PurchaseMoney purchaseMoney, WinningNumbers winningNumbers, WinningResult winningResult) {
        this.purchaseMoney = purchaseMoney;
        this.winningNumbers = winningNumbers;
        this.winningResult = winningResult;
    }

    public void compareWinningNumbersAndTicket(List<Integer> ticket) {
        winningNumbers.compareWithTicket(ticket);
    }

    public String getWinningResult() {
        return winningResult.toString();
    }
}
