package com.ynz.enginee.promotion.enginee.promotions;

import com.ynz.enginee.promotion.enginee.AbstractPromotion;
import com.ynz.enginee.promotion.enginee.CartPriceEngine;

public class BuyNItems extends AbstractPromotion {

    public BuyNItems(CartPriceEngine engine) {
        super(engine);
    }

    @Override
    public Double calculatePayment() {
        return super.calculatePayment();
    }
}
