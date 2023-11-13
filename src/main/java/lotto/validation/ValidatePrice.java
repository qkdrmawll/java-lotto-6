package lotto.validation;

public class ValidatePrice {
    static String PRICE;
    public boolean validatePrice(String price) {
        PRICE = price;
        if (!isNumber()) {
            throw new IllegalArgumentException();
        }
        if (!isThousand()) {
            throw new IllegalArgumentException();
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
