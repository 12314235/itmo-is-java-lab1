package org.banks.corebusinessrules.services.centralbankservice;

import org.banks.corebusinessrules.exceptions.FaultTransactionException;
import org.banks.corebusinessrules.services.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the central bank service responsible for processing transactions and managing transaction history.
 */
public class CentralBankService {
    /**
     * The list to store transaction history.
     */
    private List<Transaction> transactionHistory = new ArrayList<>();

    /**
     * Processes a transaction, adds it to the transaction history, and executes it.
     * If the transaction execution fails, it undoes the transaction.
     *
     * @param transaction The transaction to be processed.
     */
    public void ProcessTransaction(Transaction transaction) {
        transactionHistory.add(transaction);

        try {
            transaction.Execute();
        } catch (FaultTransactionException ex) {
            transaction.Undo();
        }
    }
}
