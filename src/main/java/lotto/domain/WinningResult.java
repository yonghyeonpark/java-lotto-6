package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;

public class WinningResult {

    private static final String PRIZE_MONEY_FORMAT = "(#,###원)";
    private static final String SPACE = " ";
    private static final String SPACE_DASH_SPACE = " - ";
    private static final String COUNT_UNIT = "개";
    private static final String NEW_LINE = "\n";

    private final Map<Rank, Integer> winningResult;

    public WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
        setUp();
    }

    private void setUp() {
        winningResult.put(Rank.FIRST_PLACE, 0);
        winningResult.put(Rank.SECOND_PLACE, 0);
        winningResult.put(Rank.THIRD_PLACE, 0);
        winningResult.put(Rank.FOURTH_PLACE, 0);
        winningResult.put(Rank.FIFTH_PLACE, 0);
    }

    public Map<Rank, Integer> getWinningResult() {
        return winningResult;
    }

    public void judgeRank(int matchingCount, boolean hasMatchingBonusNumber) {
        if (matchingCount == Rank.FIRST_PLACE.getMatchingCount()) {
            addFirstPlace();
        }
        if (matchingCount == Rank.SECOND_PLACE.getMatchingCount()) {
            if (hasMatchingBonusNumber) {
                addSecondPlace();
            }
            if (!hasMatchingBonusNumber) {
                addThirdPlace();
            }
        }
        if (matchingCount == Rank.FOURTH_PLACE.getMatchingCount()) {
            addFourthPlace();
        }
        if (matchingCount == Rank.FIFTH_PLACE.getMatchingCount()) {
            addFifthPlace();
        }
    }

    private void addFirstPlace() {
        winningResult.put(Rank.FIRST_PLACE, winningResult.get(Rank.FIRST_PLACE) + 1);
    }

    private void addSecondPlace() {
        winningResult.put(Rank.SECOND_PLACE, winningResult.get(Rank.SECOND_PLACE) + 1);
    }

    private void addThirdPlace() {
        winningResult.put(Rank.THIRD_PLACE, winningResult.get(Rank.THIRD_PLACE) + 1);
    }

    private void addFourthPlace() {
        winningResult.put(Rank.FOURTH_PLACE, winningResult.get(Rank.FOURTH_PLACE) + 1);
    }

    private void addFifthPlace() {
        winningResult.put(Rank.FIFTH_PLACE, winningResult.get(Rank.FIFTH_PLACE) + 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat(PRIZE_MONEY_FORMAT);
        for (Rank rank : Rank.values()) {
            stringBuilder.append(rank.getDetail())
                    .append(SPACE)
                    .append(decimalFormat.format(rank.getPrizeMoney()))
                    .append(SPACE_DASH_SPACE)
                    .append(winningResult.get(rank))
                    .append(COUNT_UNIT)
                    .append(NEW_LINE);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
