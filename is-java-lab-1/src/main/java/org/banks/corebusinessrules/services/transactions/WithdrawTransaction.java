package org.banks.corebusinessrules.services.transactions;

import lombok.ToString;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.math.BigDecimal;
import java.util.Optional;

@ToString
public class WithdrawTransaction extends Transaction {
    private BigDecimal amount;

    public WithdrawTransaction(Account receiver, Account sender, BigDecimal amount) {
        super(receiver, sender);
        this.amount = amount;
    }

    @Override
    public void Execute() throws FaultTransactionException {
        this.receiverSnapshot = Optional.of(this.receiver.TakeSnapshot());

        try {
            if (this.receiver.IsWithdrawPossible(amount)) {
                this.receiver.WithdrawBalance(amount);
            }
            else {
                throw new FaultTransactionException("Withdraw is not possible, account: " + receiver.toString());
            }
        }
        catch (FaultTransactionException ex) {
            throw new FaultTransactionException(ex.getMessage() + "\n transaction: " + this.toString());
        }
    }

    @Override
    public void Undo() {
        this.receiverSnapshot.ifPresent(this.receiver::Restore);
    }
}
