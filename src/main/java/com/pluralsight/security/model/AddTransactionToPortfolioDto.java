package com.pluralsight.security.model;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTransactionToPortfolioDto {

    @NonNull
    private String cryptoSymbol;
    @NonNull
    private String quantity;
    @NonNull
    private String price;
    @NonNull
    private String type;
    private String username;

}
