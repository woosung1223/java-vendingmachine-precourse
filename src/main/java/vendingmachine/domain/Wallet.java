package vendingmachine.domain;

import java.util.*;

public class Wallet {
    private final List<Coin> coins;

    public Wallet(List<Coin> coins) {
        this.coins = coins;
        coins.sort((o1, o2) -> o2.getAmount() - o1.getAmount());
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Map<Coin, Integer> makeChange(int money) {
        Map<Coin, Integer> change = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            change.put(coin, 0);
        }

        for (Coin coin : coins) {
            if (money >= coin.getAmount()) {
                money -= coin.getAmount();
                change.put(coin, change.get(coin) + 1);
            }
        }
        return change;
    }
}
