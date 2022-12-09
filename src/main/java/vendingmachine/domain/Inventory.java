package vendingmachine.domain;

import java.util.Comparator;
import java.util.List;

public class Inventory {
    private final List<Product> products;

    public Inventory(List<Product> products) {
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

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
