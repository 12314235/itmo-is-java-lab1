package org.banks.corebusinessrules.entities.transactions;

import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.banks.Bank;

import java.math.BigDecimal;

public class TransferTransaction extends Transaction {
    private BigDecimal amount;

    public TransferTransaction(Bank receiver, Bank sender, long receiverId, long senderId, BigDecimal amount) {
        super(receiver, sender, receiverId, senderId);
        this.amount = amount;
    }

    @Override
    public void Execute() {

    }
}
