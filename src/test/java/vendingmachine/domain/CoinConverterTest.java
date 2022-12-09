package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CoinConverterTest {

    @Test
    void 돈이_랜덤한_코인으로_잘_변환되는지_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    CoinConverter coinConverter = new CoinConverter();

                    assertThat(coinConverter.convertToRandomCoins(450))
                            .isEqualTo(
                                    Arrays.asList(Coin.COIN_100, Coin.COIN_100, Coin.COIN_100, Coin.COIN_100, Coin.COIN_50)
                            );
                },
                100, 100, 100, 100, 50
        );
    }
}