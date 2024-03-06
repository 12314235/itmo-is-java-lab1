package org.banks.corebusinessrules.services.transactions.builders;

import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.services.transactions.RefillTransaction;
import org.banks.corebusinessrules.services.transactions.Transaction;

import java.math.BigDecimal;

public class RefillTransactionBuilder implements TransactionBuilder {
    private Account receiver;
    private Account sender;
    private BigDecimal amount;


    @Override
    public TransactionBuilder WithAmount(BigDecimal amount) {
        this.amount = amount;

        return this;
    }

    @Override
    public TransactionBuilder WithSender(Account sender) {
        this.sender = sender;

        return this;
    }

    @Override
    public TransactionBuilder WithReceiver(Account receiver) {
        this.receiver = receiver;

        return this;
    }

    @Override
    public Transaction Build() {
        return new RefillTransaction(receiver, sender, amount);
    }
}

