package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public int readHoldingMoney() {
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public List<String> readProducts() {
        String line = Console.readLine();
        return Arrays.asList(
                line.substring(1, line.length() - 1)
                .split(",")
        );
    }

    public int readUserMoney() {
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public String readProductToBuy() {
        String line = Console.readLine();
        return line;
    }
}
