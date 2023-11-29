package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final String RATE_OF_RETURN_FORMAT = "#,##0.0%";

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

    public String calculateRateOfReturn() {
        DecimalFormat decimalFormat = new DecimalFormat(RATE_OF_RETURN_FORMAT);
        double rateOfReturn = (double) calculateTotalPrizeMoney() / (double) purchaseMoney.getPurchaseMoney();
        return decimalFormat.format(rateOfReturn);
    }

    private int calculateTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        Map<Rank, Integer> result = winningResult.getWinningResult();
        for (Rank rank : Rank.values()) {
            totalPrizeMoney += (rank.getPrizeMoney() * result.get(rank));
        }
        return totalPrizeMoney;
    }
}
