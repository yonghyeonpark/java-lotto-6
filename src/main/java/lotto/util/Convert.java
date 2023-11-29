package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력하셔야 합니다.";

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static List<Integer> stringToIntegerListByNaturalOrder(String input) {
        List<Integer> list = new ArrayList<>();
        String[] split = input.split(",");
        for (String element : split) {
            list.add(stringToInt(element));
        }
        return list;
    }
}
