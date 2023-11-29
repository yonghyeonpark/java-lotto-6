package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Sort;

public class LottoMachine {

    private final List<List<Integer>> tickets;

    public LottoMachine() {
        this.tickets = new ArrayList<>();
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
}
