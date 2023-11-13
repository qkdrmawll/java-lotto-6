package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.validation.ValidatePrice;
import lotto.view.LottoView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    LottoView lottoView = new LottoView();
    ValidatePrice validatePrice = new ValidatePrice();
    LottoService lottoService = new LottoService();

    String purchaseErrMsg = "[ERROR] 구입 금액은 1000 단위의 숫자를 입력해야 합니다.";
    public void makePurchase() {
        lottoView.inputPurchasePrice();
        String purchasePrice = readLine();
        try {
            validatePrice.validatePrice(purchasePrice);
        }catch (IllegalArgumentException e) {
            System.out.println(purchaseErrMsg);
        }
        int lottoNum = Integer.parseInt(purchasePrice)/1000;
        List<Lotto> lottoList = lottoService.generateLotto(lottoNum);
        lottoView.printLotto(lottoList);
    }
    public void drawForWinner() {

    }
    public void setWinningDetails() {

    }
}
