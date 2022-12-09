package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.view.OutputView;

import java.util.List;

public class MachineController {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private VendingMachine vendingMachine;

    public void run() {

        Wallet wallet = inputController.readWallet();
        wallet.makeMoneyToRandomCoins();
        outputView.printCoins(wallet.getCoins());

        List<Product> products = inputController.readProducts();

        vendingMachine = new VendingMachine(wallet, products);

        vendingMachine.putMoney(inputController.readUserMoney());

        while (!vendingMachine.isServiceOver()) {
            outputView.printCurrentMoney(vendingMachine.getCustomerMoney());
            Product product = inputController.readProductToBuy();
            vendingMachine.buy(product);
        }

        outputView.printChange(vendingMachine.getChange());
    }
}
