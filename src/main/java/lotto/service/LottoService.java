package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoService {
    static List<Lotto> lottos = new LinkedList<>();
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

}
