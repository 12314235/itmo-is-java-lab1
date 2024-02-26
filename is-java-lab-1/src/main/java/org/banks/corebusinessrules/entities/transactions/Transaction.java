package org.banks.corebusinessrules.entities.transactions;

import lombok.Getter;
import org.banks.corebusinessrules.entities.accounts.Account;

@Getter
public abstract class Transaction {
    final private Account receiver;
    final private Account sender;

    public Transaction(Account receiver, Account sender) {
        this.receiver = receiver;
        this.sender = sender;
    }

    public abstract void Execute();
}
