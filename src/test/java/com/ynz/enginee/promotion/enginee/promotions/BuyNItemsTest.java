package com.ynz.enginee.promotion.enginee.promotions;

import com.ynz.enginee.promotion.domain.Cart;
import com.ynz.enginee.promotion.enginee.CartPriceEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BuyNItemsTest {
    @Autowired
    private Cart cart;

    @Autowired
    private CartPriceEngine engine;

    @Test
    void whenCartHavingThreeA_TotalPriceIs130() {
        cart.addSkuAndAmount('A', 3);
        BuyNItems buyNItems = new BuyNItems(engine);
        assertEquals(130, buyNItems.calculatePayment());
    }

    @Test
    void whenCartHavingTwoB_TotalPriceIS45() {
        cart.addSkuAndAmount('B', 2);
        BuyNItems buyNItems = new BuyNItems(engine);
        assertEquals(45, buyNItems.calculatePayment());
    }

    @Test
    void whenCartHavingThreeATwoB_TotalPriceIs175() {
        cart.addSkuAndAmount('A', 3);
        cart.addSkuAndAmount('B', 2);
        BuyNItems buyNItems = new BuyNItems(engine);
        assertEquals(175, buyNItems.calculatePayment());
    }

    //Scenario B
    @Test
    void whenCartHaving5A5B1C_TotalPriceIs370() {
        cart.addSkuAndAmount('A', 5);
        cart.addSkuAndAmount('B', 5);
        cart.addSkuAndAmount('C', 1);
        BuyNItems buyNItems = new BuyNItems(engine);
        assertEquals(370, buyNItems.calculatePayment());
    }

}