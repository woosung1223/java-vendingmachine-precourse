package vendingmachine.controller;

import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.Wallet;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.stream.Collectors;

public class MachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void run() {
        prepareRoutine();
        serviceRoutine();
        endRoutine();
    }

    private void prepareRoutine() {
        Wallet wallet = setWallet();
        outputView.printCoins(wallet.getCoins());
        Inventory inventory = setInventory();

        vendingMachine = new VendingMachine(wallet, inventory);
    }

    private Wallet setWallet() {
        try {
            return new Wallet(inputView.readHoldingMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWallet();
        }
    }

    private Inventory setInventory() {
        try {
            return new Inventory(inputView.readProducts().stream()
                    .map(data -> new Product(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2))))
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setInventory();
        }
    }
    private void serviceRoutine() {
        setMoney();
        buyProduct();
    }

    private void setMoney() {
        try {
            vendingMachine.putMoney(new Money(inputView.readUserMoney()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setMoney();
        }
    }

    private void buyProduct() {
        try {
            while (!vendingMachine.isServiceOver()) {
                outputView.printCurrentMoney(vendingMachine.getCustomerMoney());
                Product product = Product.ofName(inputView.readProductToBuy());
                vendingMachine.buy(product);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyProduct();
        }
    }
    private void endRoutine() {
        outputView.printChange(vendingMachine.getChange());
    }
}
