package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Sort;

public class LottoMachine {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int COUNT = 6;
    private static final String NEW_LINE = "\n";

    private final List<List<Integer>> tickets;

    public LottoMachine() {
        this.tickets = new ArrayList<>();
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    public void execute(int count) {
        for (int i = 0; i < count; i++) {
            executeOnce();
        }
    }

    private void executeOnce() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, COUNT);
        tickets.add(Sort.naturalOrder(numbers));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> ticket : tickets) {
            stringBuilder.append(ticket)
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
