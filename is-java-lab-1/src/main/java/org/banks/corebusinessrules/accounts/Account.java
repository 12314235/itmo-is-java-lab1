package org.banks.corebusinessrules.accounts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.models.resulttypes.AccountOperationResult;
import org.banks.corebusinessrules.models.resulttypes.ResultStatus;
import org.banks.corebusinessrules.services.timemanager.observers.TimeManagerObserver;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@ToString
public abstract class Account implements TimeManagerObserver {
    @Getter
    private final UUID id;
    private final LocalDateTime initTime;
    private final Client owner;
    private final String password;
    private final BigDecimal limit;
    private BigDecimal balance;
    private final VerificationStrategy verificationStrategy;

    public AccountOperationResult RefillBalance(BigDecimal amount) throws FaultTransactionException {
        if(verificationStrategy.IsVerificatedOperation(this.limit, amount)) {
            balance = balance.add(amount);

            return new AccountOperationResult(this.id, "Succesully refilled balance.", ResultStatus.Success);
        }
        else {
            throw new FaultTransactionException("Refill transaction fault account: " + this.toString());
        }
    }

    public AccountOperationResult WithdrawBalance(BigDecimal amount) throws FaultTransactionException {
        if(verificationStrategy.IsVerificatedOperation(this.limit, amount)) {
            balance = balance.subtract(amount);

            return new AccountOperationResult(this.id, "Succesully withdrawed balance.", ResultStatus.Success);
        }
        else {
            throw new FaultTransactionException("Withdraw transaction fault account: " + this.toString());
        }
    }

    public boolean CheckPassword(String password) {
        return this.password.equals(password);
    }

    public AccountMemento TakeSnapshot() {
        return new AccountMemento(this.balance);
    }

    public void Restore (AccountMemento memento) {
        this.balance = memento.balance;
    }
    public abstract boolean IsRefillPossible(BigDecimal amount);
    public abstract boolean IsWithdrawPossible(BigDecimal amount);
    public abstract void UpdateBalance();

    @RequiredArgsConstructor
    public class AccountMemento {
        private final BigDecimal balance;
    }
}
