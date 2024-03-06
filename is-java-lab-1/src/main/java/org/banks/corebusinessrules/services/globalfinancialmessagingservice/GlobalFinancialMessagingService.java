package org.banks.corebusinessrules.services.globalfinancialmessagingservice;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.paymentorder.PaymentOrder;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.repositories.BankRepository;
import org.banks.corebusinessrules.services.transactions.builders.TransactionBuilder;

@RequiredArgsConstructor
public class GlobalFinancialMessagingService {
    final private CentralBankService centralBank;
    final private BankRepository bankRepository;

    public void ProcessPaymentOrder(PaymentOrder order) {
        TransactionBuilder builder = order.transactionBuilder();
        Bank bankReceiver = bankRepository.GetBankById(order.receiverBankId());
        Bank bankSender = bankRepository.GetBankById(order.senderBankId());

        try {
            bankReceiver.GetReceiverAccount(builder, order.receiverAccountId());
            bankSender.GetSenderAccount(builder, order.senderAccountId());
        }
        catch (ClassNotFoundException ex) {
            return;
        }

        centralBank.ProcessTransaction(builder
                .WithAmount(order.amount())
                .Build());
    }
}
