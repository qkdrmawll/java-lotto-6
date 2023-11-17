package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoService {
    static List<Lotto> lottos = new LinkedList<>();
    static int[] winningResult;
    public List<Lotto> generateLotto(int numOfLotto) {
        for (int i=0;i<numOfLotto;i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int[] drawForWinning(Lotto inputLotto, int bonusNum) {
        winningResult = new int[5];
        for (Lotto lotto : lottos) {
            int matchNumber = lotto.checkNumbersMatch(inputLotto);
            boolean isMatchBonus = lotto.isContainNumber(bonusNum);
            int grade = checkGrade(matchNumber,isMatchBonus);
            if (grade >= 0) {
                winningResult[grade]++;
            }
        }
        return winningResult;
    }

    private int checkGrade(int matchNumber, boolean isMatchBonus) {
        if (matchNumber == 6) {
            return 4;
        }
        if (matchNumber == 5) {
            if (isMatchBonus) {
                return 3;
            }
            return 2;
        }
        return matchNumber - 3;
    }

    public double calculateRateOfReturn(int purchasePrice, int[] winningDetails) {
        int profit = calculateProfit(winningDetails);
        double rateOfReturn = (double) profit/(double)purchasePrice * 100;
        rateOfReturn = adjustPoint(rateOfReturn);
        return rateOfReturn;
    }

    private Double adjustPoint(double rateOfReturn) {
        return Math.round(rateOfReturn*10)/10.0;
    }

    private int calculateProfit(int[] winningDetails) {
        int profit = 0;
        profit += winningDetails[0] * 5000;
        profit += winningDetails[1] * 50000;
        profit += winningDetails[2] * 1500000;
        profit += winningDetails[3] * 30000000;
        profit += winningDetails[4] * 2000000000;
        return profit;
    }
}
