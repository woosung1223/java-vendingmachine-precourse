package vendingmachine.domain;

import java.util.Collections;
import java.util.List;

public class VendingMachine {
    private final List<Coin> holdingCoins;
    private final List<Product> products;

    public VendingMachine(int holdingMoney, List<Product> products) {
        CoinConverter coinConverter = new CoinConverter();

        this.holdingCoins = coinConverter.convertToRandomCoins(holdingMoney);
        this.products = products;
    }

    public List<Coin> getHoldingCoins() {
        return Collections.unmodifiableList(holdingCoins);
    }
}
