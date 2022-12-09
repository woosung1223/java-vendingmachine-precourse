package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void 상품이_같을때_equals_값이_true를_반환하는지_테스트() {
        Product stockProduct = new Product("콜라", 0, 0);
        Product selectedProduct = new Product("콜라", 0, 10);
        assertThat(stockProduct.equals(selectedProduct)).isTrue();
    }

    @Test
    void 가격이_다를때_equals_값이_false를_반환하는지_테스트() {
        Product stockProduct = new Product("콜라", 0, 0);
        Product selectedProduct = new Product("콜라", 1000, 10);
        assertThat(stockProduct.equals(selectedProduct)).isFalse();
    }

    @Test
    void 이름이_다를때_equals_값이_false를_반환하는지_테스트() {
        Product stockProduct = new Product("콜라", 0, 0);
        Product selectedProduct = new Product("사이다", 0, 10);
        assertThat(stockProduct.equals(selectedProduct)).isFalse();
    }
}