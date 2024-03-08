package org.banks.corebusinessrules.accounts.builders;

import org.banks.corebusinessrules.accounts.DebitAccount;
import org.banks.corebusinessrules.accounts.percentage.DebitPercentage;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DebitAccountBuilder {
    private UUID id;
    private LocalDateTime currentTime;
    private Client owner;
    private String password;
    private BigDecimal limit;
    private VerificationStrategy verificationStrategy;
    private DebitPercentage percentage;

    public DebitAccountBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public DebitAccountBuilder setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    public DebitAccountBuilder setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    public DebitAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public DebitAccountBuilder setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    public DebitAccountBuilder setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
        return this;
    }

    public DebitAccountBuilder setPercentage(DebitPercentage percentage) {
        this.percentage = percentage;
        return this;
    }

    public DebitAccount createDebitAccount() {
        return new DebitAccount(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }
}