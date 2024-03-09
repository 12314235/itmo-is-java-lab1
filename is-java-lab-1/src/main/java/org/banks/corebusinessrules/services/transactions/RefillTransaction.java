package org.banks.corebusinessrules.services.transactions;

import lombok.ToString;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Represents a refill transaction, where an amount of money is transferred to an account.
 */
@ToString
public class RefillTransaction extends Transaction {
    /**
     * The amount of money to be refilled into the account.
     */
    private BigDecimal amount;

    /**
     * Constructs a new refill transaction.
     *
     * @param receiver The account to receive the refill.
     * @param sender   The account from which the refill is made.
     * @param amount   The amount of money to be refilled.
     */
    public RefillTransaction(Account receiver, Account sender, BigDecimal amount) {
        super(receiver, sender);
        this.amount = amount;
    }

    /**
     * Executes the refill transaction.
     *
     * @throws FaultTransactionException If the refill transaction encounters an error.
     */
    @Override
    public void execute() throws FaultTransactionException {
        this.receiverSnapshot = Optional.of(this.receiver.takeSnapshot());

        try {
            if (this.receiver.isRefillPossible(amount)) {
                this.receiver.refillBalance(amount);
            } else {
                throw new FaultTransactionException("Refill is not possible, account: " + receiver.toString());
            }
        } catch (FaultTransactionException ex) {
            throw new FaultTransactionException(ex.getMessage() + "\n transaction: " + this.toString());
        }
    }

    /**
     * Undoes the refill transaction by restoring the receiver's account to its previous state.
     */
    @Override
    public void undo() {
        this.receiverSnapshot.ifPresent(this.receiver::restore);
    }
}
