package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

class LottoControllerTest {
    LottoController lottoController = new LottoController();
    private static final String purchaseErrMsg = "구매금액을 입력해 주세요.\n" +
            "[ERROR] 구입 금액은 1000 단위의 숫자를 입력해야 합니다.\n";
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }
    @Test
    @DisplayName("로또 구매 Controller 테스트")
    void makePurchase() {
        String input = "10003";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        lottoController.makePurchase();
        Assertions.assertThat(outputMessage.toString()).isEqualTo(purchaseErrMsg);
    }

    @Test
    void drawForWinner() {
    }

    @Test
    void setWinningDetails() {
    }
}