package com.ynz.enginee.promotion.domain;

import java.util.HashMap;
import java.util.Map;


public class Cart {
    //sku and amount
    private Map<Character, Integer> skuAmountMap = new HashMap<>();

    public void addSkuAndAmount(Character character, Integer amount) {
        skuAmountMap.put(character, amount);
    }

    public Integer getSkuAmount(Character character) {
        return skuAmountMap.get(character);
    }

}
