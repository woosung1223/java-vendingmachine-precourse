package vendingmachine.domain;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private int count;

    public Product(String name, int price, int count) {
        validate(name, price, count);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public static Product ofName(String name) {
        return new Product(name, 100, 1);
    }

    public void sell() {
        count--;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAbsent() {
        return count <= 0;
    }

    private void validate(String name, int price, int count) {
        checkNameIsNotEmpty(name);
        checkPriceNotSmall(price);
        checkPriceIsDivisible(price);
        checkCountPositive(count);
    }

    private void checkNameIsNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 상품의 이름은 한 글자 이상 존재해야 합니다.");
        }
    }

    private void checkPriceNotSmall(int price) {
        if (price < 100) {
            throw new IllegalArgumentException("[ERROR] 상품의 가격은 100원 이상이어야 합니다.");
        }
    }

    private void checkPriceIsDivisible(int price) {
        if (price % Coin.getSmallestAmount() != 0) {
            throw new IllegalArgumentException("[ERROR] 상품의 가격은 1원 단위여서는 안됩니다.");
        }
    }

    private void checkCountPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("[ERROR] 상품의 재고는 1개 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product)other;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
