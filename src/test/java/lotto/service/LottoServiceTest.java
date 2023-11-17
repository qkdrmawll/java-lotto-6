package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 생성 테스트")
    void generateLotto() {
        List<Lotto> lottoList = lottoService.generateLotto(3);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    @Test
    @DisplayName("당첨 결과 테스트")
    void drawForWinning() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,21,3,4,15,16)));
        LottoService.lottos = lottos;

        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        //when
        int[]result = lottoService.drawForWinning(lotto,7);
        //then
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[4]).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 테스트")
    void calculateRateOfReturn() {
        //given
        int purchasePrice = 8000;
        int[] winningDetails = {1,0,0,0,0};
        //when
        Double rateOfReturn = lottoService.calculateRateOfReturn(purchasePrice,winningDetails);
        //then
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}