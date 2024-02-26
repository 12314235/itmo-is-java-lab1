package org.banks.corebusinessrules.entities.transactions;

import lombok.Getter;
import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.banks.Bank;

@Getter
public abstract class Transaction {
    final private Bank receiver;
    final private Bank sender;
    final private long receiverId;
    final private long senderId;

    public Transaction(Bank receiver, Bank sender, long receiverId, long senderId) {
        this.receiver = receiver;
        this.sender = sender;
        this.receiverId = receiverId;
        this.senderId = senderId;
    }

    public abstract void Execute();
}
