package com.ynz.enginee.promotion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@PropertySource("price.properties")
public class AppConfig {

    @Value("#{${priceMap}}")
    private Map<Character, Integer> priceMap;

    @Bean
    public Map<Character, Integer> priceMap() {
        return priceMap;
    }

}
