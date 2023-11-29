package lotto.domain;

import java.util.List;

public class Lotto {

    private static final String LOTTO_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개입니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long deduplication = numbers.stream().distinct().count();
        if (deduplication != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
