package org.banks.corebusinessrules.services.transactions;

import lombok.Data;
import lombok.Getter;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.exceptions.FaultTransactionException;

import java.util.Optional;

@Data
public abstract class Transaction {
    final protected Account receiver;
    final protected Account sender;
    protected Optional<Account.AccountMemento> senderSnapshot;
    protected Optional<Account.AccountMemento> receiverSnapshot;

    public abstract void Execute() throws FaultTransactionException;
    public abstract void Undo();
}

