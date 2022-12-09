package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.view.OutputView;

import java.util.List;

public class MachineController {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void run() {
        prepareRoutine();
        serviceRoutine();
        endRoutine();
    }

    private void prepareRoutine() {
        Wallet wallet = inputController.readWallet();
        wallet.makeMoneyToRandomCoins();
        outputView.printCoins(wallet.getCoins());
        List<Product> products = inputController.readProducts();

        vendingMachine = new VendingMachine(wallet, products);
    }

    private void serviceRoutine() {
        vendingMachine.putMoney(inputController.readUserMoney());

        while (!vendingMachine.isServiceOver()) {
            outputView.printCurrentMoney(vendingMachine.getCustomerMoney());
            Product product = inputController.readProductToBuy();
            vendingMachine.buy(product);
        }
    }

    private void endRoutine() {
        outputView.printChange(vendingMachine.getChange());
    }
}
