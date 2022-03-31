package com.bootcamp.bankclient.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private String id;
    private String accountNumber;
    private double balance;
    private String currency;
    private String accountType;
    private String canBeDeposit;
}
