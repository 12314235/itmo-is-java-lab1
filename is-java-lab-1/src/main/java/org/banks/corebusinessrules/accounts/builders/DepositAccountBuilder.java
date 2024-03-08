package org.banks.corebusinessrules.accounts.builders;

import org.banks.corebusinessrules.accounts.DepositAccount;
import org.banks.corebusinessrules.accounts.percentage.DepositPercentage;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DepositAccountBuilder {
    private UUID id;
    private LocalDateTime currentTime;
    private Client owner;
    private String password;
    private BigDecimal limit;
    private VerificationStrategy verificationStrategy;
    private DepositPercentage percentage;
    private LocalDateTime accountTerm;

    public DepositAccountBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public DepositAccountBuilder setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    public DepositAccountBuilder setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    public DepositAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public DepositAccountBuilder setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    public DepositAccountBuilder setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
        return this;
    }

    public DepositAccountBuilder setPercentage(DepositPercentage percentage) {
        this.percentage = percentage;
        return this;
    }

    public DepositAccountBuilder setAccountTerm(LocalDateTime accountTerm) {
        this.accountTerm = accountTerm;
        return this;
    }

    public DepositAccount createDepositAccount() {
        return new DepositAccount(id, currentTime, owner, password, limit, verificationStrategy, percentage, accountTerm);
    }
}