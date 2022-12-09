package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Wallet wallet;
    private final Inventory products;
    private Money customerMoney;

    public VendingMachine(Wallet wallet, List<Product> products) {
        this.wallet = wallet;
        this.products = new Inventory(products);
    }

    public void putMoney(Money money) {
        customerMoney = money;
    }

    public void buy(Product toBuy) {
        Product productSelected = products.takeOutProduct(toBuy);
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
        Product cheapestProduct = products.getCheapestProduct();
        return customerMoney.isSmallerThan(cheapestProduct.getPrice());
    }

    private boolean isNotEnoughProduct() {
        return products.isNoProductCanBuyWith(customerMoney);
    }
}
