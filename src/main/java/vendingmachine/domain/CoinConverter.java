package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class CoinConverter {
    public List<Coin> convertToRandomCoins(int money) {
        List<Coin> coins = new ArrayList<>();
        while (money >= Coin.getSmallestAmount()){
            Coin randomCoin = getCoinWithAmountLimit(money);
            money -= randomCoin.getAmount();
            coins.add(randomCoin);
        }
        return coins;
    }

    private Coin getCoinWithAmountLimit(int limit) {
        Coin randomCoin;
        do {
            randomCoin = Coin.getRandomCoin();
        } while (randomCoin.getAmount() > limit);
        return randomCoin;
    }
}
