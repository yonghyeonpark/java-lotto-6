package lotto.domain;

public enum Rank {

    FIRST_PLACE(6, "6개 일치", 2_000_000_000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD_PLACE(5, "5개 일치", 1_500_000),
    FOURTH_PLACE(4, "4개 일치", 50_000),
    FIFTH_PLACE(3, "3개 일치", 5_000);

    private int matchingCount;
    private String detail;
    private int prizeMoney;

    Rank(int matchingCount, String detail, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.detail = detail;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
