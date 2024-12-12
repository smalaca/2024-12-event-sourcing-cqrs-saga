package com.smalaca.bankaccountquery;

import java.time.LocalDateTime;
import java.util.UUID;

public class BankAccountDataModel {
    private UUID bankAccountId;
    private UUID ownerId;
    private String accountNumber;
    private int balance;
    private LocalDateTime lastUpdateDateTime;

    public UUID getBankAccountId() {
        return bankAccountId;
    }

    void setBankAccountId(UUID bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDateTime getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    void setLastUpdateDateTime(LocalDateTime lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    boolean isOlderThan(LocalDateTime localDateTime) {
        return lastUpdateDateTime == null || lastUpdateDateTime.isBefore(localDateTime);
    }
}
