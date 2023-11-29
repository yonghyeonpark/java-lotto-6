package lotto.view;

public class OutputView {

    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_START_FORMAT = "당첨 통계";
    private static final String LINE = "---";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %s입니다.";

    public void printPurchaseLotto(int purchaseCount, String purchaseLotto) {
        System.out.println();
        System.out.print(String.format(PURCHASE_COUNT_FORMAT, purchaseCount));
        System.out.println();
        System.out.println(purchaseLotto);
    }

    public void printWinningStatistics(String result, String rateOfReturn) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_START_FORMAT);
        System.out.println(LINE);
        System.out.println(result);
        System.out.print(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn));
    }
}
