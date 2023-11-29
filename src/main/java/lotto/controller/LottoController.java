package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void execute() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();
        purchaseLotto(purchaseMoney);
        WinningResult winningResult = new WinningResult(new HashMap<>());
        Lotto lotto = getLotto();
        while (true) {
            try {
                WinningNumbers winningNumbers = new WinningNumbers(lotto, getBonusNumber(), winningResult);
                lottoGame = new LottoGame(purchaseMoney, winningNumbers, winningResult);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        play();
        printResult();
    }

    private PurchaseMoney getPurchaseMoney() {
        while (true) {
            try {
                PurchaseMoney purchaseMoney = new PurchaseMoney(inputView.readPurchaseMoney());
                return purchaseMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void purchaseLotto(PurchaseMoney purchaseMoney) {
        int purchaseCount = purchaseMoney.getPurchaseCount();
        lottoMachine.execute(purchaseCount);
        outputView.printPurchaseLotto(purchaseCount, lottoMachine.toString());
    }

    private Lotto getLotto() {
        while (true) {
            try {
                Lotto lotto = new Lotto(inputView.readWinningNumbers());
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber() {
        System.out.println();
        while (true) {
            try {
                BonusNumber bonusNumber = new BonusNumber(inputView.readBonusNumber());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void play() {
        for (List<Integer> ticket : lottoMachine.getTickets()) {
            lottoGame.compareWinningNumbersAndTicket(ticket);
        }
    }

    private void printResult() {
        outputView.printWinningStatistics(lottoGame.getWinningResult(), lottoGame.calculateRateOfReturn());
    }
}
