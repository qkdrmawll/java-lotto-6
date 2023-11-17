package lotto.validation;

public class ValidatePrice {
    static String PRICE;
    public boolean validatePrice(String price) {
        PRICE = price;
        if (!isNumber()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자로 입력해야 합니다.");
        }
        if (!isThousand()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return true;
    }

    private boolean isNumber() {
        return PRICE.matches("^[0-9]+$");
    }

    private boolean isThousand() {
        return Integer.parseInt(PRICE) % 1000 == 0;
    }


}
