package vendingmachine.domain;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private int count;

    public Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product)other;
        return Objects.equals(name, product.name) &&
                price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
