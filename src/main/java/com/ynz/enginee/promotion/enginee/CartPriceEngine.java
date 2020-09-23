package com.ynz.enginee.promotion.enginee;

import com.ynz.enginee.promotion.domain.Cart;

import java.util.Map;


public class CartPriceEngine implements Payable {
    private final Map<Character, Integer> priceMap;
    private final Cart cart;

    public CartPriceEngine(Cart cart, Map<Character, Integer> priceMap) {
        this.cart = cart;
        this.priceMap = priceMap;
    }

    @Override
    public Double calculatePayment() {

        return null;
    }

}
