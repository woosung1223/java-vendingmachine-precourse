package vendingmachine.domain;

import java.util.*;

public class VendingMachine {
    private final Wallet wallet;
    private final List<Product> products;
    private int customerMoney = 0; // TODO: 감싸기

    public VendingMachine(Wallet wallet, List<Product> products) {
        this.wallet = wallet;
        this.products = products;
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

    public int getCustomerMoney() {
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

        return cheapestProduct.getPrice() > customerMoney;
    }

    private boolean isNotEnoughProduct() {
        return products.stream()
                .filter(product -> product.getPrice() <= customerMoney)
                .allMatch(Product::isAbsent);
    }
}
