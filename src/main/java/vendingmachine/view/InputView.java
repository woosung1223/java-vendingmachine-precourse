package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String READ_HOLDING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final String READ_PRODUCTS_MESSAGE = "상품명 가격, 수량을 입력해주세요.";
    private final String READ_USER_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
    private final String READ_PRODUCTS_TO_BUY_MESSAGE = "구매할 상품명을 입력해 주세요.";

    public int readHoldingMoney() {
        System.out.println(READ_HOLDING_MONEY_MESSAGE);
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public List<List<String>> readProducts() {
        System.out.println(READ_PRODUCTS_MESSAGE);
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
        System.out.println(READ_USER_MONEY_MESSAGE);
        String line = Console.readLine();
        return Integer.parseInt(line);
    }

    public String readProductToBuy() {
        System.out.println(READ_PRODUCTS_TO_BUY_MESSAGE);
        String line = Console.readLine();
        return line;
    }
}
