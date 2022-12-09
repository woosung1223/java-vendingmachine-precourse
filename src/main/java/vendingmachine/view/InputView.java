package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int readHoldingMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public List<List<String>> readProducts() {
        System.out.println("상품명 가격, 수량을 입력해 주세요.");
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
        System.out.println("투입 금액을 입력해 주세요.");
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public String readProductToBuy() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String line = Console.readLine();
        return line;
    }
}
