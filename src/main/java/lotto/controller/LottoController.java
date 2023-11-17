package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.validation.ValidateBonusNumber;
import lotto.validation.ValidateInputWinningNumber;
import lotto.validation.ValidatePrice;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    LottoView lottoView = new LottoView();
    ValidatePrice priceValidator = new ValidatePrice();
    ValidateInputWinningNumber winningNumberValidator = new ValidateInputWinningNumber();
    ValidateBonusNumber bonusNumberValidator = new ValidateBonusNumber();
    LottoService lottoService = new LottoService();
    static int purchasePrice;
    static Lotto winningNumberLotto;

    public void makePurchase() {
        String inputPurchasePrice = "";
        while (inputPurchasePrice.isEmpty()) {
            inputPurchasePrice = getInputPurchasePrice();
        }
        purchasePrice = Integer.parseInt(inputPurchasePrice);
        int lottoNum = purchasePrice/1000;
        List<Lotto> lottoList = lottoService.generateLotto(lottoNum);
        lottoView.printLotto(lottoList);
    }

    private String getInputPurchasePrice() {
        lottoView.inputPurchasePrice();
        String inputPurchasePrice = readLine();
        try {
            priceValidator.validatePrice(inputPurchasePrice);
            return inputPurchasePrice;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public int[] drawForWinner() {
        List<Integer> winningNumber = getInputWinningNumber();
        while (winningNumber.isEmpty()) {
            winningNumber = getInputWinningNumber();
        }
        winningNumberLotto = new Lotto(winningNumber);
        int bonusNumber=-1;
        while (bonusNumber == -1) {
            bonusNumber = getInputBonusNumber();
        }
        return lottoService.drawForWinning(winningNumberLotto,bonusNumber);
    }

    private int getInputBonusNumber() {
        lottoView.inputBonusNumber();
        String inputBonusNumber = readLine();
        int bonusNumber = -1;
        try {
            bonusNumber = bonusNumberValidator.validateBonusNumber(inputBonusNumber, winningNumberLotto);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bonusNumber;
    }

    private List<Integer> getInputWinningNumber() {
        lottoView.inputWinningNumber();
        String[] inputWinningNumber = readLine().split(",");
        try {
            winningNumberValidator.validateWinningNumber(inputWinningNumber);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
        List<Integer> winningNumber = new ArrayList<>();
        for (String s : inputWinningNumber) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    public void setWinningDetails(int[] winningDetails) {
        lottoView.printWinningDetails(winningDetails);
        double rateOfReturn = lottoService.calculateRateOfReturn(purchasePrice,winningDetails);
        lottoView.printRateOfReturn(rateOfReturn);
    }
}
