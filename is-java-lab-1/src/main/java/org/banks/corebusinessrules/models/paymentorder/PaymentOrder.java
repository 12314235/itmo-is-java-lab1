package org.banks.corebusinessrules.models.paymentorder;

import org.banks.corebusinessrules.services.transactions.builders.TransactionBuilder;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents PaymentOrder for GlobalFinancialMessagingService for creating an instance of transaction
 */
public record PaymentOrder(TransactionBuilder transactionBuilder,
                           UUID senderBankId,
                           UUID senderAccountId,
                           UUID receiverBankId,
                           UUID receiverAccountId,
                           BigDecimal amount) {
}
