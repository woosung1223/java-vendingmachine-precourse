package vendingmachine.domain;

import java.util.Collections;
import java.util.List;

public class VendingMachine {
    private final List<Coin> holdingCoins;
    private final List<Product> products;
    private int customerMoney = 0;

    public VendingMachine(int holdingMoney, List<Product> products) {
        CoinConverter coinConverter = new CoinConverter();

        this.holdingCoins = coinConverter.convertToRandomCoins(holdingMoney);
        this.products = products;
    }

    public List<Coin> getHoldingCoins() {
        return Collections.unmodifiableList(holdingCoins);
    }

    public void putMoney(int money) {
        customerMoney = money;
    }

    public void buy(Product toBuy) {
        Product productSelected = products.stream()
                .filter(product -> product.equals(toBuy))
                .findFirst()
                .get();

        productSelected.sell();
        customerMoney -= productSelected.getPrice();
    }
}
