package org.banks.corebusinessrules.entities.banks;

import lombok.Getter;
import org.banks.corebusinessrules.entities.accounts.Account;

@Getter
public class Bank {
    final private long id;

    public Bank(long id) {
        this.id = id;
    }


}
