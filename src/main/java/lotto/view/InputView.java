package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Convert;

public class InputView {

    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구매 금액을 입력해 주세요.";

    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int readPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        return Convert.stringToInt(readLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return Convert.stringToIntegerList(readLine());
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Convert.stringToInt(readLine());
    }
}
