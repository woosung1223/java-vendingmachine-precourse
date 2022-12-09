package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Wallet;
import vendingmachine.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class InputController {
    private final InputView inputView = new InputView();

    public Wallet readWallet() {
        try {
            return new Wallet(inputView.readHoldingMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWallet();
        }
    }

    public List<Product> readProducts() {
        try {
            List<List<String>> products = inputView.readProducts();
            return products.stream()
                    .map(data -> new Product(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2))))
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readProducts();
        }
    }

    public Money readUserMoney() {
        try {
            return new Money(inputView.readUserMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readUserMoney();
        }
    }

    public Product readProductToBuy() {
        try {
            String productToBuy = inputView.readProductToBuy();
            return Product.ofName(productToBuy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readProductToBuy();
        }
    }
}
