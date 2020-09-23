package com.ynz.enginee.promotion.enginee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
class CartPriceEngineTest {
    @Autowired
    private CartPriceEngine engine;

    @AfterEach
    void tearDown() {
        engine.getCart().getSkuAmountMap().clear();
    }

    @Test
    void engineInjectedSuccessfully() {
        assertNotNull(engine);
        assertNotNull(engine.getCart());
    }

    @Test
    void whenNoPromotionTriggered_CartEngineCalculatePayment() {
        engine.getCart().addSkuAndAmount('A', 1);
        engine.getCart().addSkuAndAmount('B', 1);
        engine.getCart().addSkuAndAmount('C', 1);

        assumeTrue(engine.getPriceMap().keySet().containsAll(engine.getCart().getAllSKU()));

        Integer totalPayment = engine.calculatePayment();
        assertThat(totalPayment, is(100));
    }

    @Test
    void whenSKUInCartHavingNoPrice_ThenThrowException() {
        engine.getCart().addSkuAndAmount('A', 1);
        engine.getCart().addSkuAndAmount('B', 1);
        engine.getCart().addSkuAndAmount('G', 1);

        Throwable exception = assertThrows(IllegalStateException.class, () -> engine.calculatePayment());
        assertEquals(exception.getMessage(), "SKU missing price plan.");
    }
}