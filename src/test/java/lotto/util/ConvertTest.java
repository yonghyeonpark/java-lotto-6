package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ConvertTest {

    @DisplayName("문자열을 쉼표 기준으로 정수형 리스트로 변환한다.")
    @Test
    void stringToIntegerList() {
        List<Integer> integers = Convert.stringToIntegerList("1,2,3,4,5,6");

        assertThat(integers.size()).isEqualTo(6);
        assertThat(integers.get(0)).isEqualTo(1);
        assertThat(integers.get(1)).isEqualTo(2);
        assertThat(integers.get(2)).isEqualTo(3);
        assertThat(integers.get(3)).isEqualTo(4);
        assertThat(integers.get(4)).isEqualTo(5);
        assertThat(integers.get(5)).isEqualTo(6);
    }

    @Nested
    @DisplayName("문자열을 정수로 변환하는 과정에서 발생하는 예외를 잡아 고의로 IllegalArgumentException을 발생시킨다.")
    class StringToIntegerExceptionTest {

        @DisplayName("문자열이 공백이면 예외가 발생한다.")
        @Test
        void should_ThrowIllegalArgumentException_When_Blank() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Convert.stringToInteger(""))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("문자열이 숫자가 아니면 예외가 발생한다.")
        @Test
        void should_ThrowIllegalArgumentException_When_NonInteger() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Convert.stringToInteger("a"))
                    .withMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("문자열을 정수형 리스트로 변환하는 과정에서 발생하는 예외를 잡아 고의로 IllegalArgumentException을 발생시킨다.")
    class StringToIntegerListException {

        @DisplayName("문자열에 공백이 포함되어 있으면 예외가 발생한다.")
        @Test
        void should_ThrowIllegalArgumentException_When_Blank() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Convert.stringToIntegerList("1,2,3,,5,6"))
                    .withMessageContaining("[ERROR]");
        }

        @DisplayName("문자열에 숫자가 아닌 입력이 포함되어 있으면 예외가 발생한다.")
        @Test
        void should_ThrowIllegalArgumentException_When_NonInteger() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Convert.stringToIntegerList("1,2,3,f,5,6"))
                    .withMessageContaining("[ERROR]");
        }
    }
}