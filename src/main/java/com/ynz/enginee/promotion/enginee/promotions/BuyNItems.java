package com.ynz.enginee.promotion.enginee.promotions;

import com.ynz.enginee.promotion.domain.Cart;
import com.ynz.enginee.promotion.enginee.AbstractPromotion;
import com.ynz.enginee.promotion.enginee.CartPriceEngine;
import com.ynz.enginee.promotion.enginee.Payable;

import java.util.HashMap;
import java.util.Map;

public class BuyNItems extends AbstractPromotion {
    private static final int THREE_A_SAVE = 20;
    private static final int TWO_B_SAVE = 15;

    private enum ResultType {
        REMINDER, TIMES;
    }

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
                Map<ResultType, Integer> r = findTimesAndReminder(numOfA, 3);
                int times = r.get(ResultType.TIMES);
                saving += times * THREE_A_SAVE;
            }
        }

        if (cart.getAllSKU().contains('B')) {
            int numOfB = cart.getSkuAmount('B');
            if (numOfB >= 2) {
                Map<ResultType, Integer> r = findTimesAndReminder(numOfB, 2);
                int times = r.get(ResultType.TIMES);
                saving += times * TWO_B_SAVE;
            }
        }

        return super.calculatePayment() - saving;
    }

    private Map<ResultType, Integer> findTimesAndReminder(Integer x, Integer y) {
        Map<ResultType, Integer> result = new HashMap<>();

        result.put(ResultType.REMINDER, findReminder(x, y));
        result.put(ResultType.TIMES, findTimes(x, y));

        return result;
    }

    //find times x over y
    private Integer findTimes(Integer x, Integer y) {
        if (x < y) throw new IllegalArgumentException("x must greater than y");
        return x / y;
    }

    //find reminder x over y
    private Integer findReminder(Integer x, Integer y) {
        if (x < y) throw new IllegalArgumentException("x must greater than y");
        return x % y;
    }
}
