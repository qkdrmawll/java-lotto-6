package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();

    public void makePurchase() {
        boolean priceValidFlag = false;
        while (!priceValidFlag) {
            priceValidFlag = getInputPurchasePrice();
        }
        List<Lotto> lottos = lottoService.publishLotto();
        outputView.printLotto(lottos);
    }

    private boolean getInputPurchasePrice() {
        inputView.inputPurchasePrice();
        String inputPurchasePrice = readLine();
        try {
            lottoService.createLottos(inputPurchasePrice);
            return true;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
