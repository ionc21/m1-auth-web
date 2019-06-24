package com.pluralsight.security.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(exclude = { "id", "name" })
@ToString
@Document
public class CryptoCurrency {

    @Indexed(unique = true)
    private final String symbol;

    private final String name;

    @Id
    private String id;

}
