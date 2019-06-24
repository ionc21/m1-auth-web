package com.pluralsight.security.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@ToString
public class Transaction {

    @DBRef
    private final CryptoCurrency cryptoCurrency;
    private final Type type;
    private final BigDecimal quantity;
    private final BigDecimal price;
    private final long timestamp;
    @Id
    private String id;

    public Transaction(CryptoCurrency cryptoCurrency, Type type, BigDecimal quantity, BigDecimal price,
            long timestamp) {
        this.cryptoCurrency = cryptoCurrency;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = timestamp;
        this.id = new ObjectId().toHexString();
    }

}
