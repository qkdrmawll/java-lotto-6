package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputWinningNumberTest {
    ValidateInputWinningNumber validate = new ValidateInputWinningNumber();

    @Test
    @DisplayName("당첨번호 유효성 검사 통과 테스트")
    void validateWinningNumber_O() {
        String input = "1,2,3,4,5,6";
        String[] numbers = input.split(",");
        assertThat(validate.validateWinningNumber(numbers)).isTrue();
    }
    @Test
    @DisplayName("당첨번호 유효성 검사 범위 실패 테스트")
    void validateWinningNumber_range_X() {
        String input = "1,2,3,4,5,61";
        String[] numbers = input.split(",");
        assertThrows(IllegalArgumentException.class,()->validate.validateWinningNumber(numbers));
    }
    @Test
    @DisplayName("당첨번호 유효성 검사 6자 실패 테스트")
    void validateWinningNumber_6_X() {
        String input = "1,2,3,4,5";
        String[] numbers = input.split(",");
        assertThrows(IllegalArgumentException.class,()->validate.validateWinningNumber(numbers));
    }
    @Test
    @DisplayName("당첨번호 유효성 검사 문자 실패 테스트")
    void validateWinningNumber_num_X() {
        String input = "1,2,3,4,5,k";
        String[] numbers = input.split(",");
        assertThrows(IllegalArgumentException.class,()->validate.validateWinningNumber(numbers));
    }
}