package org.banks.corebusinessrules.services.transactions;

import lombok.ToString;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Represents a transfer transaction, where an amount of money is transferred from one account to another.
 */
@ToString
public class TransferTransaction extends Transaction {
    /**
     * The amount of money to be transferred.
     */
    private BigDecimal amount;

    /**
     * Constructs a new transfer transaction.
     *
     * @param receiver The account to which the money is transferred.
     * @param sender   The account from which the money is transferred.
     * @param amount   The amount of money to be transferred.
     */
    public TransferTransaction(Account receiver, Account sender, BigDecimal amount) {
        super(receiver, sender);
        this.amount = amount;
    }

    /**
     * Executes the transfer transaction by withdrawing money from the sender's account
     * and depositing it into the receiver's account.
     *
     * @throws FaultTransactionException If the transfer transaction encounters an error.
     */
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

    /**
     * Undoes the transfer transaction by restoring both the sender's and receiver's accounts to their previous states.
     */
    @Override
    public void Undo() {
        this.receiverSnapshot.ifPresent(this.receiver::Restore);
        this.senderSnapshot.ifPresent(this.sender::Restore);
    }
}
