package org.banks.corebusinessrules.entities.transactions;

import org.banks.corebusinessrules.entities.accounts.Account;

import java.math.BigDecimal;

public class TransferTransaction extends Transaction {
    private BigDecimal amount;

    public TransferTransaction(Account receiver, Account sender, BigDecimal amount) {
        super(receiver, sender);
        this.amount = amount;
    }

    @Override
    public void Execute() {

    }
}
