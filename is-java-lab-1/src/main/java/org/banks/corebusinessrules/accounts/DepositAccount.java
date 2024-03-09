package org.banks.corebusinessrules.accounts;

import org.banks.corebusinessrules.accounts.percentage.DepositPercentage;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a deposit account in the bank.
 * Inherits from the Account abstract class.
 */
public class DepositAccount extends Account {

    private final LocalDateTime accountTerm;

    /**
     * Constructs a new DepositAccount instance with the specified parameters.
     *
     * @param id                   The unique identifier of the account.
     * @param currentTime          The current time of the account.
     * @param owner                The owner of the account.
     * @param password             The password for the account.
     * @param limit                The limit for the account operations.
     * @param verificationStrategy The verification strategy for the account operations.
     * @param percentage           The percentage strategy for the account.
     * @param accountTerm          The term until which the account is active.
     */
    public DepositAccount(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, DepositPercentage percentage, LocalDateTime accountTerm) {
        super(id, currentTime, owner, password, limit, verificationStrategy, percentage);
        this.accountTerm = accountTerm;
    }

    /**
     * Checks if it's possible to refill the deposit account balance by the specified amount.
     * In a deposit account, refill is possible if the account term has not yet expired.
     *
     * @param amount The amount to check for refill possibility.
     * @return true indicating refill is possible.
     */
    @Override
    public boolean IsRefillPossible(BigDecimal amount) {
        return accountTerm.isBefore(this.currentTime);
    }

    /**
     * Checks if it's possible to withdraw the deposit account balance by the specified amount.
     * In a deposit account, withdrawal is possible if the account term has not yet expired.
     *
     * @param amount The amount to check for withdraw possibility.
     * @return true indicating withdraw is possible.
     */
    @Override
    public boolean IsWithdrawPossible(BigDecimal amount) {
        return accountTerm.isBefore(this.currentTime);
    }

    /**
     * Reacts to the change in time by updating the account state.
     * If the current day is the first day of the month, it updates the account balance.
     *
     * @param time The new time value.
     */
    @Override
    public void ReactToTimeChange(LocalDateTime time) {
        this.currentTime = time;
        if (this.currentTime.getDayOfMonth() == 1) {
            this.UpdateBalance();
        }
    }

    /**
     * Reacts to the change in percentage strategy by updating the account percentage strategy.
     *
     * @param percentage The new percentage strategy.
     */
    @Override
    public void ReactToPercentageStrategyChange(PercentageStrategy percentage) {
        if (percentage instanceof DepositPercentage) {
            this.percentage = percentage;
        }
    }
}
