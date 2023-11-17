package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size()!=6) {
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현

    public int checkNumbersMatch(Lotto lotto) {
        List<Integer> otherNumbers = lotto.numbers;
        int matchNum = 0;
        for (Integer i : otherNumbers) {
            if (isContainNumber(i)){
                matchNum++;
            }
        }
        return matchNum;
    }

    public boolean isContainNumber(Integer i) {
        return numbers.contains(i);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Integer i:numbers) {
            stringBuilder.append(i).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
