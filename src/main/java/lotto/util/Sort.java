package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {

    public static List<Integer> naturalOrder(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }
}
