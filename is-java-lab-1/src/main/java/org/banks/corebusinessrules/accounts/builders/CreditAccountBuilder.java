package org.banks.corebusinessrules.accounts.builders;

import org.banks.corebusinessrules.accounts.CreditAccount;
import org.banks.corebusinessrules.accounts.percentage.CreditPercentage;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreditAccountBuilder {
    private UUID id;
    private LocalDateTime currentTime;
    private Client owner;
    private String password;
    private BigDecimal limit;
    private VerificationStrategy verificationStrategy;
    private CreditPercentage percentage;

    public CreditAccountBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public CreditAccountBuilder setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    public CreditAccountBuilder setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    public CreditAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public CreditAccountBuilder setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    public CreditAccountBuilder setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
        return this;
    }

    public CreditAccountBuilder setPercentage(CreditPercentage percentage) {
        this.percentage = percentage;
        return this;
    }

    public CreditAccount createCreditAccount() {
        return new CreditAccount(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }
}