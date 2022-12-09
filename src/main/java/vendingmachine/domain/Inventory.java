package vendingmachine.domain;

import java.util.Comparator;
import java.util.List;

public class Inventory {
    private final List<Product> products;

    public Inventory(List<Product> products) {
        validate(products);
        this.products = products;
    }

    public Product takeOutProduct(Product toBuy) {
        return products.stream()
                .filter(product -> product.equals(toBuy))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public Product getCheapestProduct() {
        return products.stream()
                .min(Comparator.comparingInt(Product::getPrice))
                .orElseThrow(RuntimeException::new);
    }

    public boolean isNoProductCanBuyWith(Money price) {
        return products.stream()
                .filter(product -> product.getPrice() <= price.get())
                .allMatch(Product::isAbsent);
    }

    private void validate(List<Product> products) {
        checkNotEmpty(products);
    }

    private void checkNotEmpty(List<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 상품은 1개 이상 존재해야 합니다.");
        }
    }
}
