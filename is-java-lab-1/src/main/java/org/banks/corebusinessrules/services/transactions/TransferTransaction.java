package org.banks.corebusinessrules.services.transactions;

import lombok.ToString;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.math.BigDecimal;
import java.util.Optional;

@ToString
public class TransferTransaction extends Transaction {
    private BigDecimal amount;

    public TransferTransaction(Account receiver, Account sender, BigDecimal amount) {
        super(receiver, sender);
        this.amount = amount;
    }

    @Override
    public void Execute() throws FaultTransactionException {
        this.senderSnapshot = Optional.of(this.sender.TakeSnapshot());
        this.receiverSnapshot = Optional.of(this.receiver.TakeSnapshot());

        try {
            if (!this.sender.IsWithdrawPossible(amount)) {
                throw new FaultTransactionException("Transfer transaction fault, withdraw is not possible, sender: " + this.sender.toString() + "\n receiver: " + this.receiver.toString());
            }

            if (!this.receiver.IsRefillPossible(amount)) {
                throw new FaultTransactionException("Transfer transaction fault, withdraw is not possible, sender: " + this.sender.toString() + "\n receiver: " + this.receiver.toString());
            }

            this.sender.WithdrawBalance(amount);
            this.receiver.RefillBalance(amount);

        } catch (FaultTransactionException ex) {

            throw new FaultTransactionException(ex.getMessage() + "\n transaction: " + this.toString());
        }
    }

    @Override
    public void Undo() {
        this.receiverSnapshot.ifPresent(this.receiver::Restore);
        this.senderSnapshot.ifPresent(this.sender::Restore);
    }
}

