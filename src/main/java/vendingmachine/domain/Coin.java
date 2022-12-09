package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Coin getRandomCoin() {
        List<Integer> amounts = Arrays.stream(values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());

        return getCoinByAmount(Randoms.pickNumberInList(amounts));
    }

    public static Coin getCoinByAmount(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.getAmount() == amount)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int getAmount() {
        return amount;
    }
}
