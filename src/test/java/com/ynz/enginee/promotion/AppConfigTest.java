package com.ynz.enginee.promotion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class AppConfigTest {
    @Autowired
    private Map<Character, Integer> priceMap;

    @Test
    void injectedPricesAsExpected() {
        assertAll(
                () -> assertThat(priceMap.get('A'), is(50)),
                () -> assertThat(priceMap.get('B'), is(30)),
                () -> assertThat(priceMap.get('C'), is(20)),
                () -> assertThat(priceMap.get('D'), is(15))
        );
    }

    @Test
    void whenSkuIsNotIncluded_thenGetNullPrice() {
        assertThat(priceMap.get('F'), is(nullValue()));
    }

}