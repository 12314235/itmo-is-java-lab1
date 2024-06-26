package org.banks.corebusinessrules.services.globalfinancialmessagingservice;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.paymentorder.PaymentOrder;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.repositories.BankRepository;
import org.banks.corebusinessrules.services.transactions.builders.TransactionBuilder;

/**
 * Represents the global financial messaging service responsible for processing payment orders and creating transactions for CentralBankService.
 */
@RequiredArgsConstructor
public class GlobalFinancialMessagingService {
    /**
     * The central bank service.
     */
    final private CentralBankService centralBank;

    /**
     * The bank repository service.
     */
    final private BankRepository bankRepository;

    /**
     * Processes a payment order.
     *
     * @param order The payment order to be processed.
     */
    public void processPaymentOrder(PaymentOrder order) {
        TransactionBuilder builder = order.transactionBuilder();
        Bank bankReceiver = bankRepository.getBankById(order.receiverBankId());
        Bank bankSender = bankRepository.getBankById(order.senderBankId());

        try {
            bankReceiver.getReceiverAccount(builder, order.receiverAccountId());
            bankSender.getSenderAccount(builder, order.senderAccountId());
        } catch (ClassNotFoundException ex) {
            // Handle class not found exception
            return;
        }

        centralBank.processTransaction(builder
                .WithAmount(order.amount())
                .Build());
    }
}
