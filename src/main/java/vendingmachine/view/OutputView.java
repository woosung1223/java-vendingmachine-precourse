package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

import java.util.Map;

public class OutputView {
    private final String PRINT_COINS_MESSAGE = "자판기가 보유한 동전";
    private final String COIN_SKELETON = "%d원 - %d개" + System.lineSeparator();

    private final String PRINT_CURRENT_MONEY_MESSAGE = "투입 금액: %d원" + System.lineSeparator();

    private final String PRINT_CHANGE_MESSAGE = "잔돈";
    private final String CHANGE_SKELETON = "%d원 - %d개" + System.lineSeparator();

    public void printCoins(Map<Coin, Integer> coins) {
        System.out.println(PRINT_COINS_MESSAGE);
        coins.forEach((coin, count) -> System.out.printf(COIN_SKELETON, coin.getAmount(), count));
    }

    public void printCurrentMoney(Money money) {
        System.out.printf(PRINT_CURRENT_MONEY_MESSAGE, money.get());
    }

    public void printChange(Map<Coin, Integer> change) {
        System.out.println(PRINT_CHANGE_MESSAGE);
        change.forEach((coin, count) -> System.out.printf(CHANGE_SKELETON, coin.getAmount(), count));
    }
}
