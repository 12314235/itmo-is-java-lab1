package org.banks.corebusinessrules.entities.transactions.paymentorders;

import lombok.Getter;
import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.entities.transactions.builders.TransactionBuilder;

import java.math.BigDecimal;

public record PaymentOrder(TransactionBuilder transactionBuilder, Long senderBankId, Long senderAccountId, Long receiverBankId, Long receiverAccountId, BigDecimal amount) {
}
