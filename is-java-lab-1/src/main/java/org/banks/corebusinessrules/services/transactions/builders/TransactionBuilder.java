package org.banks.corebusinessrules.services.transactions.builders;

import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.services.transactions.Transaction;

import java.math.BigDecimal;

public interface TransactionBuilder {
    public TransactionBuilder WithAmount(BigDecimal amount);
    public TransactionBuilder WithSender(Account sender);
    public TransactionBuilder WithReceiver(Account receiver);
    public Transaction Build();
}

