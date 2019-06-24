package com.pluralsight.security.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DummyPricingService implements PricingService {

    @Override
    public BigDecimal getCurrentPriceForCrypto(String symbol) {
        return new BigDecimal("11000.00");
    }

}
