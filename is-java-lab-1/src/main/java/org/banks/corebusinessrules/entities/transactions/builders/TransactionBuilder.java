package org.banks.corebusinessrules.entities.transactions.builders;

import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.transactions.Transaction;

import java.math.BigDecimal;

public interface TransactionBuilder {
    public TransactionBuilder WithAmount(BigDecimal amount);
    public TransactionBuilder WithSender(Account account);
    public TransactionBuilder WithReceiver(Account account);
    public Transaction Build();
}
