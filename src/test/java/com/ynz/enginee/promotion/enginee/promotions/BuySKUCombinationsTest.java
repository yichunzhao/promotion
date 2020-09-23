package com.ynz.enginee.promotion.enginee.promotions;

import com.ynz.enginee.promotion.domain.Cart;
import com.ynz.enginee.promotion.enginee.CartPriceEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BuySKUCombinationsTest {
    @Autowired
    private CartPriceEngine engine;

    @Autowired
    private Cart cart;

    @Test
    void whenOneCAndOneD_PriceAfterPromotionIs30() {
        cart.addSkuAndAmount('C', 1);
        cart.addSkuAndAmount('D', 1);

        BuySKUCombinations buySKUCombinations = new BuySKUCombinations(engine);
        Integer paymentAfterPromotion = buySKUCombinations.calculatePayment();

        assertEquals(30, paymentAfterPromotion);
    }

    @Test
    void whenOneABCDRespectively_PriceAfterPromotionIs110() {
        cart.addSkuAndAmount('A', 1);
        cart.addSkuAndAmount('B', 1);
        cart.addSkuAndAmount('C', 1);
        cart.addSkuAndAmount('D', 1);

        BuySKUCombinations buySKUCombinations = new BuySKUCombinations(engine);
        Integer paymentAfterPromotion = buySKUCombinations.calculatePayment();

        assertEquals(110, paymentAfterPromotion);
    }

    @Test
    void whenOneABCRespectivelyAndTwoD_PriceAfterPromotionIs110() {
        cart.addSkuAndAmount('A', 1);
        cart.addSkuAndAmount('B', 1);
        cart.addSkuAndAmount('C', 1);
        cart.addSkuAndAmount('D', 2);

        BuySKUCombinations buySKUCombinations = new BuySKUCombinations(engine);
        Integer paymentAfterPromotion = buySKUCombinations.calculatePayment();
        assertEquals(125, paymentAfterPromotion);
    }

}