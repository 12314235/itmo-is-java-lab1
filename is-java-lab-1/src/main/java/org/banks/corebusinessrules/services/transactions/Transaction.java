package org.banks.corebusinessrules.services.transactions;

import lombok.Data;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents a transaction between two accounts.
 * Transaction entities flow: PaymentOrder -> GlobalFinancialMessagingService -> Transaction -> CentralBankService
 */
@Data
public abstract class Transaction {
    final protected UUID transactionId;
    /**
     * The receiver account of the transaction.
     */
    final protected Account receiver;

    /**
     * The sender account of the transaction.
     */
    final protected Account sender;

    /**
     * Snapshot of the sender's account state before the transaction.
     */
    protected Optional<Account.AccountMemento> senderSnapshot;

    /**
     * Snapshot of the receiver's account state before the transaction.
     */
    protected Optional<Account.AccountMemento> receiverSnapshot;

    /**
     * Executes the transaction.
     *
     * @throws FaultTransactionException If the transaction encounters an error.
     */
    public abstract void Execute() throws FaultTransactionException;

    /**
     * Undoes the transaction.
     */
    public abstract void Undo();
}
