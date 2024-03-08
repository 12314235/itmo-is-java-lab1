package org.banks.corebusinessrules.accounts;

import lombok.Builder;
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

    public Account(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, PercentageStrategy percentage) {
        this.id = id;
        this.currentTime = currentTime;
        this.owner = owner;
        this.password = password;
        this.limit = limit;
        this.verificationStrategy = verificationStrategy;
        this.percentage = percentage;
    }

    public AccountOperationResult RefillBalance(BigDecimal amount) throws FaultTransactionException {
        if (verificationStrategy.IsVerificatedOperation(this.limit, amount)) {
            balance = balance.add(amount);

            return new AccountOperationResult(this.id, "Succesully refilled balance.", ResultStatus.Success);
        } else {
            throw new FaultTransactionException("Refill transaction fault account: " + this.toString());
        }
    }

    public AccountOperationResult WithdrawBalance(BigDecimal amount) throws FaultTransactionException {
        if (verificationStrategy.IsVerificatedOperation(this.limit, amount)) {
            balance = balance.subtract(amount);

            return new AccountOperationResult(this.id, "Succesully withdrawed balance.", ResultStatus.Success);
        } else {
            throw new FaultTransactionException("Withdraw transaction fault account: " + this.toString());
        }
    }

    public boolean CheckPassword(String password) {
        return this.password.equals(password);
    }

    public AccountMemento TakeSnapshot() {
        return new AccountMemento(this.balance);
    }

    public void Restore(AccountMemento memento) {
        this.balance = memento.balance;
    }

    protected void UpdateBalance() {
        this.balance = this.percentage.DoPercentageCalculations(this.balance);
    }

    public abstract boolean IsRefillPossible(BigDecimal amount);

    public abstract boolean IsWithdrawPossible(BigDecimal amount);

    @RequiredArgsConstructor
    public class AccountMemento {
        private final BigDecimal balance;
    }
}
