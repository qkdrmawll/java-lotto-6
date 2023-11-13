package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}