package com.ynz.enginee.promotion.enginee.promotions;

import com.ynz.enginee.promotion.domain.Cart;
import com.ynz.enginee.promotion.enginee.AbstractPromotion;
import com.ynz.enginee.promotion.enginee.Payable;

public class BuyNItems extends AbstractPromotion {
    private static final int THREE_A_SAVE = 20;
    private static final int TWO_B_SAVE = 15;

    public BuyNItems(Payable engine, Cart cart) {
        super(engine, cart);
    }

    @Override
    public Integer calculatePayment() {
        int saving = 0;

        //3 A gives a discount
        if (cart.getAllSKU().contains('A')) {
            int numOfA = cart.getSkuAmount('A');

            if (numOfA >= 3) {
                int times = findTimes(numOfA, 3);
                saving += times * THREE_A_SAVE;
            }
        }

        if (cart.getAllSKU().contains('B')) {
            int numOfB = cart.getSkuAmount('B');
            if (numOfB >= 2) {
                int times = findTimes(numOfB, 2);
                saving += times * TWO_B_SAVE;
            }
        }

        return super.calculatePayment() - saving;
    }

    //find times x over y
    private Integer findTimes(Integer x, Integer y) {
        if (x < y) throw new IllegalArgumentException("x must greater than y");
        return x / y;
    }

}
