package vendingmachine.domain;

import java.util.*;

public class VendingMachine {
    private final Wallet wallet;
    private final List<Product> products;
    private Money customerMoney;

    public VendingMachine(Wallet wallet, List<Product> products) {
        this.wallet = wallet;
        this.products = products;

        wallet.makeMoneyToRandomCoins();
    }

    public void putMoney(Money money) {
        customerMoney = money;
    }

    public void buy(Product toBuy) {
        Product productSelected = products.stream()
                .filter(product -> product.equals(toBuy))
                .findFirst()
                .get();

        productSelected.sell();
        customerMoney.spend(productSelected.getPrice());
    }

    public Money getCustomerMoney() {
        return customerMoney;
    }

    public Map<Coin, Integer> getChange() {
        return wallet.makeChange(customerMoney);
    }

    public boolean isServiceOver() {
        return isNotEnoughMoney() || isNotEnoughProduct();
    }

    private boolean isNotEnoughMoney() {
        Product cheapestProduct = products.stream()
                .min(Comparator.comparingInt(Product::getPrice))
                .get();

        return customerMoney.isSmallerThan(cheapestProduct.getPrice());
    }

    private boolean isNotEnoughProduct() {
        return products.stream()
                .filter(product -> product.getPrice() <= customerMoney.get())
                .allMatch(Product::isAbsent);
    }
}
