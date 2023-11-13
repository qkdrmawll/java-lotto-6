package lotto.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePriceTest {
    ValidatePrice validatePrice = new ValidatePrice();

    @Test
    @DisplayName("구매금액 1000단위 실패 테스트")
    void validatePrice_1000_X() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->validatePrice.validatePrice("10002"));
    }
    @Test
    @DisplayName("구매금액 1000단위 실패 테스트")
    void validatePrice_not_number() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->validatePrice.validatePrice("100p"));
    }

    @Test
    @DisplayName("구매금액 1000단위 성공 테스트")
    void validatePrice_O() {
        Assertions.assertTrue(validatePrice.validatePrice("1000"));
    }
}