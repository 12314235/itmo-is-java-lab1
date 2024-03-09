package org.banks.corebusinessrules.services.centralbankservice;

import org.banks.corebusinessrules.exceptions.FaultTransactionException;
import org.banks.corebusinessrules.services.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

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
    public void processTransaction(Transaction transaction) {
        transactionHistory.add(transaction);

        try {
            transaction.execute();
        } catch (FaultTransactionException ex) {
            transaction.undo();
        }
    }

    private <T> int findIndex(List<T> list, Predicate<T> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                return i;  // Return the index if the predicate matches
            }
        }
        return -1;  // Return -1 if no match is found
    }

    public void undoTransaction(UUID transactionId) {
        int index = findIndex(this.transactionHistory, tr -> tr.getTransactionId().equals(transactionId));

        if (index != -1) {
            for (int i = index + 1; index < this.transactionHistory.size(); i++) {
                this.processTransaction(this.transactionHistory.get(i));
            }
        }
    }
}
