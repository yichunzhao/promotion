package com.ynz.enginee.promotion.enginee;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractPromotion implements Payable {
    protected final CartPriceEngine engine;

    @Override
    public Integer calculatePayment() {
        return engine.calculatePayment();
    }
}
