package lotto;

import lotto.controller.LottoController;

public class Application {
    static LottoController lottoController = new LottoController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoController.makePurchase();
        int[] winningDetails = lottoController.drawForWinner();
        lottoController.setWinningDetails(winningDetails);
    }
}
