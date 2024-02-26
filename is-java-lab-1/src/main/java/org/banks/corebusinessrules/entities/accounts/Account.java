package org.banks.corebusinessrules.entities.accounts;

import lombok.Getter;
import org.banks.corebusinessrules.entities.banks.Bank;
import org.banks.corebusinessrules.entities.clients.Client;
import org.banks.corebusinessrules.entities.transactions.builders.RefillTransactionBuilder;
import org.banks.corebusinessrules.entities.transactions.builders.WithdrawTransactionBuilder;
import org.banks.corebusinessrules.entities.transactions.paymentorders.PaymentOrder;

import java.math.BigDecimal;

@Getter
public abstract class Account {
    final private Bank bank;
    final private long id;
    final private Client owner;

    public Account(Bank bank, long id, Client owner) {
        this.bank = bank;
        this.id = id;
        this.owner = owner;
    }

    public PaymentOrder Withdraw(BigDecimal amount) {
        return new PaymentOrder(
                new WithdrawTransactionBuilder(),
                this,
                bank.getId(),
                this.id,
                amount
        );
    }

    public PaymentOrder Refill(BigDecimal amount) {
        return new PaymentOrder(
                new RefillTransactionBuilder(),
                this,
                bank.getId(),
                this.id,
                amount
        );
    }

    public PaymentOrder Transfer(BigDecimal amount, long bankId, long accountId) {
        return new PaymentOrder(
                new WithdrawTransactionBuilder(),
                this,
                bankId,
                accountId,
                amount
        );
    }

    /// =^_^=
}
