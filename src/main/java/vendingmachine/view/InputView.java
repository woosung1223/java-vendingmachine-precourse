package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int readHoldingMoney() {
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public List<List<String>> readProducts() {
        String line = Console.readLine();
        List<String> product = Arrays.asList(line.split(";"));

        List<List<String>> products = new ArrayList<>();

        product.forEach(element -> {
            products.add(
                    Arrays.asList(element.substring(1, element.length() - 1).split(",")));
        });
        return products;
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
