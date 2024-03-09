package org.banks.corebusinessrules.services.transactions;

import lombok.ToString;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Represents a withdraw transaction, where an amount of money is withdrawn from an account.
 */
@ToString
public class WithdrawTransaction extends Transaction {
    /**
     * The amount of money to be withdrawn from the account.
     */
    private BigDecimal amount;

    /**
     * Constructs a new withdraw transaction.
     *
     * @param receiver The account from which the money is withdrawn.
     * @param sender   The account to which the withdrawn money is transferred.
     * @param amount   The amount of money to be withdrawn.
     */
    public WithdrawTransaction(Account receiver, Account sender, BigDecimal amount) {
        super(receiver, sender);
        this.amount = amount;
    }

    /**
     * Executes the withdraw transaction.
     *
     * @throws FaultTransactionException If the withdraw transaction encounters an error.
     */
    @Override
    public void Execute() throws FaultTransactionException {
        this.receiverSnapshot = Optional.of(this.receiver.TakeSnapshot());

        try {
            if (this.receiver.IsWithdrawPossible(amount)) {
                this.receiver.WithdrawBalance(amount);
            } else {
                throw new FaultTransactionException("Withdraw is not possible, account: " + receiver.toString());
            }
        } catch (FaultTransactionException ex) {
            throw new FaultTransactionException(ex.getMessage() + "\n transaction: " + this.toString());
        }
    }

    /**
     * Undoes the withdraw transaction by restoring the receiver's account to its previous state.
     */
    @Override
    public void Undo() {
        this.receiverSnapshot.ifPresent(this.receiver::Restore);
    }
}
