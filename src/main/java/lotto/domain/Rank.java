package lotto.domain;

public enum Rank {

    FIRST_PLACE("6개 일치", 2_000_000_000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD_PLACE("5개 일치", 1_500_000),
    FOURTH_PLACE("4개 일치", 50_000),
    FIFTH_PLACE("3개 일치", 5_000);

    private String detail;
    private int prizeMoney;

    Rank(String detail, int prizeMoney) {
        this.detail = detail;
        this.prizeMoney = prizeMoney;
    }
}
