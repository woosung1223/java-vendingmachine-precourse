package vendingmachine.domain;

import java.util.*;

public class Wallet {
    private List<Coin> coins;

    public Wallet(int money) {
        validate(money);
        this.coins = makeMoneyToRandomCoins(money);
    }

    public List<Coin> makeMoneyToRandomCoins(int money) {
        CoinConverter coinConverter = new CoinConverter();
        return coinConverter.convertToRandomCoins(money);
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

    private void validate(int money) {
        checkPositive(money);
        checkDivisible(money);
    }

    private void checkPositive(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 자판기는 0원 이상을 보유해야 합니다.");
        }
    }

    private void checkDivisible(int money) {
        if (money % Coin.getSmallestAmount() != 0) {
            throw new IllegalArgumentException("[ERROR] 1원 단위로는 입력할 수 없습니다.");
        }
    }
}
