package com.pluralsight.security.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Document
@RequiredArgsConstructor
@Getter
public class Portfolio {

    @NonNull
    private final String username;
    private final List<Transaction> transactions;
    @Id
    private String id;

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public List<Transaction> getTransactionsForCoin(String symbol) {
        return transactions.stream().filter(transaction -> transaction.getCryptoCurrency().getSymbol().equals(symbol))
                .collect(Collectors.toList());
    }

    public void deleteTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public Transaction getTransactionById(String id) {
        for (Transaction transaction : this.transactions) {
            if (id.equals(transaction.getId())) {
                return transaction;
            }
        }
        return null;
    }

}
