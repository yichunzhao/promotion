package com.ynz.enginee.promotion.enginee;

import com.ynz.enginee.promotion.domain.Cart;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * The base total price calculator without any promotion.
 */
@Component
public class CartPriceEngine implements Payable {
    @Getter
    private final Map<Character, Integer> priceMap;

    @Getter
    private final Cart cart;

    public CartPriceEngine(Cart cart, Map<Character, Integer> priceMap) {
        this.cart = cart;
        this.priceMap = priceMap;
    }

    @Override
    public Integer calculatePayment() {
        if (!priceMap.keySet().containsAll(cart.getAllSKU()))
            throw new IllegalStateException("SKU missing price plan.");
        return cart.getAllSKU().stream()
                .mapToInt(character -> cart.getSkuAmount(character) * priceMap.get(character))
                .sum();
    }

}
