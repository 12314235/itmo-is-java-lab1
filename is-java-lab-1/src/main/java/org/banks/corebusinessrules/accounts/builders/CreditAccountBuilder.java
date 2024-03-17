package org.banks.corebusinessrules.accounts.builders;

import org.banks.corebusinessrules.accounts.CreditAccount;
import org.banks.corebusinessrules.accounts.percentage.CreditPercentage;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Builder class for creating CreditAccount instances.
 */
public class CreditAccountBuilder {
    private UUID id;
    private LocalDateTime currentTime;
    private Client owner;
    private String password;
    private BigDecimal limit;
    private VerificationStrategy verificationStrategy;
    private CreditPercentage percentage;

    /**
     * Sets the ID of the credit account.
     * @param id The ID to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the current time for the credit account.
     * @param currentTime The current time to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    /**
     * Sets the owner of the credit account.
     * @param owner The owner to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Sets the password for the credit account.
     * @param password The password to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Sets the credit limit for the credit account.
     * @param limit The credit limit to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sets the verification strategy for the credit account.
     * @param verificationStrategy The verification strategy to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
        return this;
    }

    /**
     * Sets the percentage for the credit account.
     * @param percentage The percentage to set.
     * @return The CreditAccountBuilder instance.
     */
    public CreditAccountBuilder setPercentage(CreditPercentage percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Creates a new CreditAccount instance with the provided attributes.
     * @return The created CreditAccount instance.
     */
    public CreditAccount createCreditAccount() {
        return new CreditAccount(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }
}
