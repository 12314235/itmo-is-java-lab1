package org.banks.corebusinessrules.entities.transactions.builders;

import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.transactions.Transaction;
import org.banks.corebusinessrules.entities.transactions.TransferTransaction;
import org.banks.corebusinessrules.entities.transactions.WithdrawTransaction;

import java.math.BigDecimal;

public class TransferTransactionBuilder implements TransactionBuilder {
    private BigDecimal amount;
    private Account sender;
    private Account receiver;

    @Override
    public TransactionBuilder WithAmount(BigDecimal amount) {
        this.amount = amount;

        return this;
    }

    @Override
    public TransactionBuilder WithSender(Account account) {
        this.sender = account;

        return this;
    }

    @Override
    public TransactionBuilder WithReceiver(Account account) {
        this.receiver = account;

        return this;
    }

    @Override
    public Transaction Build() {
        return new TransferTransaction(receiver, sender, amount);
    }
}
