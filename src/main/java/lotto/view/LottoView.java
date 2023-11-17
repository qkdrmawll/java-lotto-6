package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoView {
    public void inputPurchasePrice() {
        System.out.println("구매금액을 입력해 주세요.");
    }
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public void printLotto(List<Lotto> lottoList) {
        int lottoListNum = lottoList.size();
        System.out.println(lottoListNum+"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }
    public void printWinningDetails(int[] winningDetails) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningDetails[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningDetails[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningDetails[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningDetails[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningDetails[4] + "개");
    }
    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " +rateOfReturn+"%입니다.");
    }
}
