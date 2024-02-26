package org.banks.corebusinessrules.entities.transactions.builders;

import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.banks.Bank;
import org.banks.corebusinessrules.entities.transactions.Transaction;

import java.math.BigDecimal;

public interface TransactionBuilder {
    public TransactionBuilder WithAmount(BigDecimal amount);
    public TransactionBuilder WithSender(Bank bank, Long accountId);
    public TransactionBuilder WithReceiver(Bank bank, Long accountId);
    public Transaction Build();
}
