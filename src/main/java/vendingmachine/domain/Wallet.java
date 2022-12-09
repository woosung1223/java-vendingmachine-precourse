package vendingmachine.domain;

import java.util.*;

public class Wallet {
    private int totalMoney;
    private List<Coin> coins;

    public Wallet(int money) {
        this.totalMoney = money;
    }

    public void makeMoneyToRandomCoins() {
        CoinConverter coinConverter = new CoinConverter();
        this.coins = coinConverter.convertToRandomCoins(totalMoney);
        coins.sort((o1, o2) -> o2.getAmount() - o1.getAmount());
    }

    public Map<Coin, Integer> getCoins() {
        Map<Coin, Integer> classifiedCoins = new LinkedHashMap<>();
        for (Coin coin : coins) {
            classifiedCoins.putIfAbsent(coin, 0);
            classifiedCoins.put(coin, Collections.frequency(coins, coin));
        }
        return classifiedCoins;
    }

    public Map<Coin, Integer> makeChange(Money money) {
        Map<Coin, Integer> change = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            change.put(coin, 0);
        }

        for (Coin coin : coins) {
            if (money.get() >= coin.getAmount()) {
                money.spend(coin.getAmount());
                change.put(coin, change.get(coin) + 1);
            }
        }
        return change;
    }
}
