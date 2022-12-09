package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Coin, Integer> change = new HashMap<>();
        for (Coin coin : coins) {
            change.put(coin, money / coin.getAmount());
            money %= coin.getAmount();
        }
        return change;
    }
}
