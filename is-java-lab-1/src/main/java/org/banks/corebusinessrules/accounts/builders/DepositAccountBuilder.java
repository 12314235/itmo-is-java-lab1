package org.banks.corebusinessrules.accounts.builders;

import org.banks.corebusinessrules.accounts.DepositAccount;
import org.banks.corebusinessrules.accounts.percentage.DepositPercentage;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Builder class for creating DepositAccount instances.
 */
public class DepositAccountBuilder {
    private UUID id;
    private LocalDateTime currentTime;
    private Client owner;
    private String password;
    private BigDecimal limit;
    private VerificationStrategy verificationStrategy;
    private DepositPercentage percentage;
    private LocalDateTime accountTerm;

    /**
     * Sets the ID of the deposit account.
     * @param id The ID to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the current time for the deposit account.
     * @param currentTime The current time to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    /**
     * Sets the owner of the deposit account.
     * @param owner The owner to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setOwner(Client owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Sets the password for the deposit account.
     * @param password The password to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Sets the limit for the deposit account.
     * @param limit The limit to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setLimit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sets the verification strategy for the deposit account.
     * @param verificationStrategy The verification strategy to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
        return this;
    }

    /**
     * Sets the percentage for the deposit account.
     * @param percentage The percentage to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setPercentage(DepositPercentage percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Sets the term for the deposit account.
     * @param accountTerm The term to set.
     * @return The DepositAccountBuilder instance.
     */
    public DepositAccountBuilder setAccountTerm(LocalDateTime accountTerm) {
        this.accountTerm = accountTerm;
        return this;
    }

    /**
     * Creates a new DepositAccount instance with the provided attributes.
     * @return The created DepositAccount instance.
     */
    public DepositAccount createDepositAccount() {
        return new DepositAccount(id, currentTime, owner, password, limit, verificationStrategy, percentage, accountTerm);
    }
}
