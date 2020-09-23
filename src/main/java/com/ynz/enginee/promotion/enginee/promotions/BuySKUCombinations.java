package com.ynz.enginee.promotion.enginee.promotions;

import com.ynz.enginee.promotion.domain.Cart;
import com.ynz.enginee.promotion.enginee.AbstractPromotion;
import com.ynz.enginee.promotion.enginee.CartPriceEngine;

import java.util.Arrays;
import java.util.Map;
import java.util.OptionalInt;

public class BuySKUCombinations extends AbstractPromotion {
    public static final int C_D_Comb_SAVING = 5;

    public BuySKUCombinations(CartPriceEngine engine, Cart cart) {
        super(engine, cart);
    }

    @Override
    public Integer calculatePayment() {
        OptionalInt numOfComb = findSKUCombinationsInCart(cart.getSkuAmountMap(), 'C', 'D');

        int saving = 0;
        if (numOfComb.isPresent()) {
            saving = C_D_Comb_SAVING * numOfComb.getAsInt();
        }
        return super.calculatePayment() - saving;
    }

    //given SKU ids, find out if they are existed at the same in the cart, and how many this kind of combinations.
    private OptionalInt findSKUCombinationsInCart(Map<Character, Integer> skuAmountMap, Character... skuIds) {
        if (!skuAmountMap.keySet().containsAll(Arrays.asList(skuIds))) return OptionalInt.of(0);
        return Arrays.stream(skuIds).mapToInt(character -> skuAmountMap.get(character)).min();
    }

}
