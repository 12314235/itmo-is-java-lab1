package org.banks.corebusinessrules.entities.transactions.paymentorders;

import lombok.Getter;
import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.transactions.builders.TransactionBuilder;

import java.math.BigDecimal;

public record PaymentOrder(TransactionBuilder transactionBuilder, Account senderAccount, Long bankId, Long accountId, BigDecimal amount) {
}
