package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Convert;

public class InputView {

    public int readInputMoney() {
        return Convert.stringToInt(readLine());
    }

    public List<Integer> readWinningNumbers() {
        return Convert.stringToIntegerList(readLine());
    }

    public int readBonusNumber() {
        return Convert.stringToInt(readLine());
    }
}
