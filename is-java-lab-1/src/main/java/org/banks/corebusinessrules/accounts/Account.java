package org.banks.corebusinessrules.accounts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.bank.BankTermsListener;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.models.resulttypes.AccountOperationResult;
import org.banks.corebusinessrules.models.resulttypes.ResultStatus;
import org.banks.corebusinessrules.services.timemanager.observers.TimeManagerObserver;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Abstract class representing an account in a bank.
 */
@ToString
public abstract class Account implements TimeManagerObserver, BankTermsListener {
    @Getter
    private final UUID id;
    protected LocalDateTime currentTime;
    private final Client owner;
    private final String password;
    private final BigDecimal limit;
    protected BigDecimal balance;
    private final VerificationStrategy verificationStrategy;
    protected PercentageStrategy percentage;

    /**
     * Constructs a new Account instance with the specified parameters.
     *
     * @param id                   The unique identifier of the account.
     * @param currentTime          The current time of the account.
     * @param owner                The owner of the account.
     * @param password             The password for the account.
     * @param limit                The limit for the account operations.
     * @param verificationStrategy The verification strategy for the account operations.
     * @param percentage           The percentage strategy for the account.
     */
    public Account(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, PercentageStrategy percentage) {
        this.id = id;
        this.currentTime = currentTime;
        this.owner = owner;
        this.password = password;
        this.limit = limit;
        this.verificationStrategy = verificationStrategy;
        this.percentage = percentage;
    }

    /**
     * Refills the balance of the account by the specified amount.
     *
     * @param amount The amount to refill the balance with.
     * @return An AccountOperationResult indicating the result of the refill operation.
     * @throws FaultTransactionException If the refill operation fails.
     */
    public AccountOperationResult refillBalance(BigDecimal amount) throws FaultTransactionException {
        if (verificationStrategy.isVerificatedOperation(this.limit, amount)) {
            balance = balance.add(amount);
            return new AccountOperationResult(this.id, "Successfully refilled balance.", ResultStatus.SUCCESS);
        } else {
            throw new FaultTransactionException("Refill transaction fault account: " + this.toString());
        }
    }

    /**
     * Withdraws the balance from the account by the specified amount.
     *
     * @param amount The amount to withdraw from the balance.
     * @return An AccountOperationResult indicating the result of the withdraw operation.
     * @throws FaultTransactionException If the withdraw operation fails.
     */
    public AccountOperationResult withdrawBalance(BigDecimal amount) throws FaultTransactionException {
        if (verificationStrategy.isVerificatedOperation(this.limit, amount)) {
            balance = balance.subtract(amount);
            return new AccountOperationResult(this.id, "Successfully withdrew balance.", ResultStatus.SUCCESS);
        } else {
            throw new FaultTransactionException("Withdraw transaction fault account: " + this.toString());
        }
    }

    /**
     * Checks if the provided password matches the account's password.
     *
     * @param password The password to check.
     * @return true if the password matches, false otherwise.
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Takes a snapshot of the account's current state.
     *
     * @return An AccountMemento representing the snapshot of the account.
     */
    public AccountMemento takeSnapshot() {
        return new AccountMemento(this.balance);
    }

    /**
     * Restores the account's state from a given snapshot.
     *
     * @param memento The AccountMemento to restore the state from.
     */
    public void restore(AccountMemento memento) {
        this.balance = memento.balance;
    }

    /**
     * Updates the balance of the account based on the percentage strategy.
     */
    protected void updateBalance() {
        this.balance = this.percentage.doPercentageCalculations(this.balance);
    }

    /**
     * Checks if it's possible to refill the account balance by the specified amount.
     *
     * @param amount The amount to check for refill possibility.
     * @return true if refill is possible, false otherwise.
     */
    public abstract boolean isRefillPossible(BigDecimal amount);

    /**
     * Checks if it's possible to withdraw the account balance by the specified amount.
     *
     * @param amount The amount to check for withdraw possibility.
     * @return true if withdraw is possible, false otherwise.
     */
    public abstract boolean isWithdrawPossible(BigDecimal amount);

    /**
     * Inner class representing a memento for storing the account's state.
     */
    @RequiredArgsConstructor
    public class AccountMemento {
        private final BigDecimal balance;
    }
}
