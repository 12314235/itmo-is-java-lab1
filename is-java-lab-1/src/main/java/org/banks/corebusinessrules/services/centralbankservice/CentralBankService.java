package org.banks.corebusinessrules.services.centralbankservice;

import org.banks.corebusinessrules.entities.transactions.Transaction;
import org.banks.corebusinessrules.services.repositories.BankRepository;

public class CentralBankService {
    final BankRepository bankRepository;

    public CentralBankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void ProcessTransaction(Transaction transaction) {
        transaction.Execute();
    }
}
