package org.banks.corebusinessrules.services.centralbankservice;

import org.banks.corebusinessrules.exceptions.FaultTransactionException;
import org.banks.corebusinessrules.services.transactions.Transaction;

import java.util.List;

public class CentralBankService {
    private List<Transaction> transactionHistory;
    public void ProcessTransaction(Transaction transaction) {
        transactionHistory.add(transaction);

        try {
            transaction.Execute();
        }
        catch (FaultTransactionException ex) {
            transaction.Undo();
        }
    }
}
