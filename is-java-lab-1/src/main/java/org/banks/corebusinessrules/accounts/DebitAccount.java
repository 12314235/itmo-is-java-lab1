package org.banks.corebusinessrules.accounts;

import org.banks.corebusinessrules.accounts.percentage.DebitPercentage;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a debit account in the bank.
 * Inherits from the Account abstract class.
 */
public class DebitAccount extends Account {

    /**
     * Constructs a new DebitAccount instance with the specified parameters.
     *
     * @param id                   The unique identifier of the account.
     * @param currentTime          The current time of the account.
     * @param owner                The owner of the account.
     * @param password             The password for the account.
     * @param limit                The limit for the account operations.
     * @param verificationStrategy The verification strategy for the account operations.
     * @param percentage           The percentage strategy for the account.
     */
    public DebitAccount(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, DebitPercentage percentage) {
        super(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }

    /**
     * Checks if it's possible to refill the debit account balance by the specified amount.
     * In a debit account, refill is always possible.
     *
     * @param amount The amount to check for refill possibility.
     * @return true indicating refill is possible.
     */
    @Override
    public boolean IsRefillPossible(BigDecimal amount) {
        return true;
    }

    /**
     * Checks if it's possible to withdraw the debit account balance by the specified amount.
     * In a debit account, withdrawal is possible if the amount is less than or equal to the balance.
     *
     * @param amount The amount to check for withdraw possibility.
     * @return true indicating withdraw is possible.
     */
    @Override
    public boolean IsWithdrawPossible(BigDecimal amount) {
        return amount.compareTo(amount) <= 0;
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
        if (percentage instanceof DebitPercentage) {
            this.percentage = percentage;
        }
    }
}
