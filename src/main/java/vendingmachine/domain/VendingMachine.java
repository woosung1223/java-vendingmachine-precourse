package vendingmachine.domain;

import java.util.Collections;
import java.util.List;

public class VendingMachine {
    private List<Coin> holdingCoins;

    public VendingMachine(int holdingMoney) {
        CoinConverter coinConverter = new CoinConverter();
        this.holdingCoins = coinConverter.convertToRandomCoins(holdingMoney);
    }

    public List<Coin> getHoldingCoins() {
        return Collections.unmodifiableList(holdingCoins);
    }
}
