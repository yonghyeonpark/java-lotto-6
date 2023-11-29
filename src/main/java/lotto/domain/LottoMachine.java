package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Sort;

public class LottoMachine {

    private static final String NEW_LINE = "\n";

    private final List<List<Integer>> tickets;

    public LottoMachine() {
        this.tickets = new ArrayList<>();
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    public List<List<Integer>> execute(int count) {
        for (int i = 0; i < count; i++) {
            executeOnce();
        }
        sortTickets();
        return tickets;
    }

    private void executeOnce() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        tickets.add(numbers);
    }

    private void sortTickets() {
        for (List<Integer> ticket : tickets) {
            Sort.naturalOrder(ticket);
        }
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
