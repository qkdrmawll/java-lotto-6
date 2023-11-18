package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottoService {
    private static Lottos lottos;
    public void createLottos(String inputPurchasePrice) {
        lottos = new Lottos(inputPurchasePrice);
        
    }
    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public List<Lotto> publishLotto() {
        int lottoNum = lottos.getPrice()/1000;
        for (int i=0;i<lottoNum;i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.addLotto(lotto);
        }
       return lottos.getLottos();
    }
}
