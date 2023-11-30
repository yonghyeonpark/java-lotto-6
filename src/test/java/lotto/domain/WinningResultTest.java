package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult(new HashMap<>());
    }

    @DisplayName("당첨 결과를 테스트한다.")
    @Nested
    class Result {

        @DisplayName("당첨 결과가 5등인 경우를 테스트")
        @Test
        void winFifthPrize() {
            winningResult.judgeRank(3, false);
            Map<Rank, Integer> result = winningResult.getWinningResult();

            assertThat(result.get(Rank.FIFTH_PLACE)).isEqualTo(1);
        }

        @DisplayName("당첨 결과가 4등인 경우를 테스트")
        @Test
        void winFourthPrize() {
            winningResult.judgeRank(4, false);
            Map<Rank, Integer> result = winningResult.getWinningResult();

            assertThat(result.get(Rank.FOURTH_PLACE)).isEqualTo(1);
        }

        @DisplayName("당첨 결과가 3등인 경우를 테스트")
        @Test
        void winThirdPrize() {
            winningResult.judgeRank(5, false);
            Map<Rank, Integer> result = winningResult.getWinningResult();

            assertThat(result.get(Rank.THIRD_PLACE)).isEqualTo(1);
        }

        @DisplayName("당첨 결과가 2등인 경우를 테스트")
        @Test
        void winSecondPrize() {
            winningResult.judgeRank(5, true);
            Map<Rank, Integer> result = winningResult.getWinningResult();

            assertThat(result.get(Rank.SECOND_PLACE)).isEqualTo(1);
        }

        @DisplayName("당첨 결과가 1등인 경우를 테스트")
        @Test
        void winFirstPrize() {
            winningResult.judgeRank(6, false);
            Map<Rank, Integer> result = winningResult.getWinningResult();

            assertThat(result.get(Rank.FIRST_PLACE)).isEqualTo(1);
        }
    }
}
