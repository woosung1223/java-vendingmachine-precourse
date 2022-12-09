package vendingmachine.domain;

import java.util.List;

public class Wallet {
    private final List<Coin> coins;

    public Wallet(List<Coin> coins) {
        this.coins = coins;
        coins.sort((o1, o2) -> o2.getAmount() - o1.getAmount());
    }

    public List<Coin> getCoins() {
        return coins;
    }
}
