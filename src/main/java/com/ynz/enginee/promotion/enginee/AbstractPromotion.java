package com.ynz.enginee.promotion.enginee;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractPromotion implements Payable {
    private final CartPriceEngine engine;

    @Override
    public Double calculatePayment() {
        return engine.calculatePayment();
    }
}
