package lotto.validation;

import lotto.domain.Lotto;

public class ValidateBonusNumber {
    static String BONUS;

    public int validateBonusNumber(String number, Lotto winngLotto) {
        BONUS = number;
        if (!isNumber()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        if (!isInTheRange()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isInWinningNumber(winngLotto)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.");
        }
        return Integer.parseInt(BONUS);
    }

    private boolean isInTheRange() {
        int i = Integer.parseInt(BONUS);
        if (i < 1 || i > 45) {
            return false;
        }
        return true;
    }

    private boolean isNumber() {
        if (!BONUS.matches("^[0-9]+$")) {
            return false;
        }
        return true;
    }
    private boolean isInWinningNumber(Lotto lotto) {
        return lotto.isContainNumber(Integer.parseInt(BONUS));
    }
}
