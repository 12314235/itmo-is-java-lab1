package org.banks.corebusinessrules.accounts.builders;

import org.banks.corebusinessrules.accounts.DebitAccount;
import org.banks.corebusinessrules.accounts.percentage.DebitPercentage;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Builder class for creating DebitAccount instances.
 */
public class DebitAccountBuilder {
    private UUID id;
    private LocalDateTime currentTime;
    private Client owner;
    private String password;
    private BigDecimal limit;
    private VerificationStrategy verificationStrategy;
    private DebitPercentage percentage;

    /**
     * Sets the ID of the debit account.
     * @param id The ID to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the current time for the debit account.
     * @param currentTime The current time to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    /**
     * Sets the owner of the debit account.
     * @param owner The owner to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Sets the password for the debit account.
     * @param password The password to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Sets the limit for the debit account.
     * @param limit The limit to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sets the verification strategy for the debit account.
     * @param verificationStrategy The verification strategy to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
        return this;
    }

    /**
     * Sets the percentage for the debit account.
     * @param percentage The percentage to set.
     * @return The DebitAccountBuilder instance.
     */
    public DebitAccountBuilder setPercentage(DebitPercentage percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Creates a new DebitAccount instance with the provided attributes.
     * @return The created DebitAccount instance.
     */
    public DebitAccount createDebitAccount() {
        return new DebitAccount(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }
}
