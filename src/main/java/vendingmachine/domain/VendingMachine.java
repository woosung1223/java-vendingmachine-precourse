package vendingmachine.domain;

import java.util.*;

public class VendingMachine {
    private final List<Coin> holdingCoins;
    private final List<Product> products;
    private int customerMoney = 0; // TODO: 감싸기

    public VendingMachine(int holdingMoney, List<Product> products) {
        CoinConverter coinConverter = new CoinConverter();

        this.holdingCoins = coinConverter.convertToRandomCoins(holdingMoney);
        this.products = products;

        holdingCoins.sort((o1, o2) -> o2.getAmount() - o1.getAmount());
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

    public Map<Coin, Integer> getChange() {
        Map<Coin, Integer> change = new HashMap<>();

        for (Coin coin : holdingCoins) {
            change.put(coin, customerMoney / coin.getAmount());
            customerMoney %= coin.getAmount();
        }
        return change;
    }

    public boolean isServiceOver() {
        return isNotEnoughMoney() || isNotEnoughProduct();
    }

    private boolean isNotEnoughMoney() {
        Product cheapestProduct = products.stream()
                .min(Comparator.comparingInt(Product::getPrice))
                .get();

        return cheapestProduct.getPrice() > customerMoney;
    }

    private boolean isNotEnoughProduct() {
        return products.stream()
                .filter(product -> product.getPrice() <= customerMoney)
                .allMatch(Product::isAbsent);
    }
}
