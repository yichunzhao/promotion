package com.ynz.enginee.promotion.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Component
public class Cart {
    //sku and amount
    private Map<Character, Integer> skuAmountMap = new HashMap<>();

    public void addSkuAndAmount(Character character, Integer amount) {
        skuAmountMap.put(character, amount);
    }

    public Integer getSkuAmount(Character character) {
        return skuAmountMap.get(character);
    }

    public Set<Character> getAllSKU(){
        return skuAmountMap.keySet();
    }

}
