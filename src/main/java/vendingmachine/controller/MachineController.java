package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class MachineController {
    InputView inputView = new InputView();
    VendingMachine vendingMachine;

    public void run() {
        inputView.readHoldingMoney();

    }
}
