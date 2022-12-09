package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoinTest {

    @Test
    void 랜덤한_코인을_잘_생성하는지_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    assertThat(Coin.getRandomCoin()).isEqualTo(Coin.COIN_10);
                    assertThat(Coin.getRandomCoin()).isEqualTo(Coin.COIN_50);
                    assertThat(Coin.getRandomCoin()).isEqualTo(Coin.COIN_100);
                    assertThat(Coin.getRandomCoin()).isEqualTo(Coin.COIN_500);
                },
                10, 50, 100, 500
        );
    }

    @Test
    void 해당_돈에_맞는_코인을_잘_반환하는지_테스트() {
        assertThat(Coin.getCoinByAmount(10)).isEqualTo(Coin.COIN_10);
        assertThat(Coin.getCoinByAmount(50)).isEqualTo(Coin.COIN_50);
        assertThat(Coin.getCoinByAmount(100)).isEqualTo(Coin.COIN_100);
        assertThat(Coin.getCoinByAmount(500)).isEqualTo(Coin.COIN_500);
    }
}