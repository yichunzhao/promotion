package com.ynz.enginee.promotion.enginee;

import com.ynz.enginee.promotion.domain.Cart;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractPromotion implements Payable {
    protected final CartPriceEngine engine;
    protected final Cart cart;

    @Override
    public Integer calculatePayment() {
        return engine.calculatePayment();
    }
}
