package lotto.validation;

public class ValidateInputWinningNumber {
    static String[] NUMBERS;
    static int SIZE = 6;
    public boolean validateWinningNumber(String[] winningNumber) {
        NUMBERS = winningNumber;
        if (!isCorrectSize()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
        if (!isNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        if(!isInTheRange()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return true;
    }

    private boolean isInTheRange() {
        for (String s : NUMBERS) {
            int i = Integer.parseInt(s);
            if(i<1 || i>45) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumber() {
        for (String s : NUMBERS) {
            if (!s.matches("^[0-9]+$")) {
                return false;
            }
        }
        return true;
    }

    private boolean isCorrectSize() {
        if (NUMBERS.length == SIZE) {
            return true;
        }
        return false;
    }
}
