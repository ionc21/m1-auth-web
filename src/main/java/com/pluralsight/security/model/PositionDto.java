package com.pluralsight.security.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class PositionDto {

    private final CryptoCurrencyDto cryptoCurrency;
    private final BigDecimal quantity;
    private final BigDecimal value;

}
