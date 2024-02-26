package org.banks.corebusinessrules.entities.transactions.builders;

import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.banks.Bank;
import org.banks.corebusinessrules.entities.transactions.RefillTransaction;
import org.banks.corebusinessrules.entities.transactions.Transaction;
import org.banks.corebusinessrules.entities.transactions.TransferTransaction;
import org.banks.corebusinessrules.entities.transactions.WithdrawTransaction;

import java.math.BigDecimal;

public class TransferTransactionBuilder implements TransactionBuilder {
    private Bank receiver;
    private Bank sender;
    private long receiverId;
    private long senderId;
    private BigDecimal amount;


    @Override
    public TransactionBuilder WithAmount(BigDecimal amount) {
        this.amount = amount;

        return this;
    }

    @Override
    public TransactionBuilder WithSender(Bank bank, Long accountId) {
        this.sender = bank;
        this.senderId = accountId;

        return this;
    }

    @Override
    public TransactionBuilder WithReceiver(Bank bank, Long accountId) {
        this.receiver = bank;
        this.receiverId = accountId;

        return this;
    }

    @Override
    public Transaction Build() {
        return new TransferTransaction(receiver, sender, receiverId, senderId, amount);
    }
}
