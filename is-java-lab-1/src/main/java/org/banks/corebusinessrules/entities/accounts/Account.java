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
    final private Long bankId;
    final private long id;
    final private Client owner;

    public Account(Long bankId, long id, Client owner) {
        this.bankId = bankId;
        this.id = id;
        this.owner = owner;
    }

    public PaymentOrder Withdraw(BigDecimal amount) {
        return new PaymentOrder(
                new WithdrawTransactionBuilder(),
                this.bankId,
                this.id,
                this.bankId,
                this.id,
                amount
        );
    }

    public PaymentOrder Refill(BigDecimal amount) {
        return new PaymentOrder(
                new RefillTransactionBuilder(),
                this.bankId,
                this.id,
                this.bankId,
                this.id,
                amount
        );
    }

    public PaymentOrder Transfer(BigDecimal amount, long bankId, long accountId) {
        return new PaymentOrder(
                new WithdrawTransactionBuilder(),
                this.bankId,
                this.id,
                bankId,
                accountId,
                amount
        );
    }

    /// =^_^=
}
