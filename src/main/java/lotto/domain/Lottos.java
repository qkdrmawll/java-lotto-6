package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private int price;

    List<Lotto> lottos = new ArrayList<>();

    public Lottos(String price) {
        validate(price);
        this.price = Integer.parseInt(price);
    }

    public int getPrice() {
        return price;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    private void validate(String price) {
        if (!isNumber(price)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자로 입력해야 합니다.");
        }
        if (!isThousand(price)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
    private boolean isNumber(String price) {
        return price.matches("^[0-9]+$");
    }

    private boolean isThousand(String price) {
        return Integer.parseInt(price) % 1000 == 0;
    }
}
