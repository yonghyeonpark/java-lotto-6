package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new HashMap<>();
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

    public void addFirstPlace() {
        winningResult.put(Rank.FIRST_PLACE, winningResult.get(Rank.FIRST_PLACE) + 1);
    }

    public void addSecondPlace() {
        winningResult.put(Rank.SECOND_PLACE, winningResult.get(Rank.SECOND_PLACE) + 1);
    }

    public void addThirdPlace() {
        winningResult.put(Rank.THIRD_PLACE, winningResult.get(Rank.THIRD_PLACE) + 1);
    }

    public void addFourthPlace() {
        winningResult.put(Rank.FOURTH_PLACE, winningResult.get(Rank.FOURTH_PLACE) + 1);
    }

    public void addFifthPlace() {
        winningResult.put(Rank.FIFTH_PLACE, winningResult.get(Rank.FIFTH_PLACE) + 1);
    }
}
