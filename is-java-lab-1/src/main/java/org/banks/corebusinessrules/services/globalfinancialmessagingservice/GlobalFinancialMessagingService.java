package org.banks.corebusinessrules.services.globalfinancialmessagingservice;

import org.banks.corebusinessrules.entities.banks.Bank;
import org.banks.corebusinessrules.entities.transactions.builders.TransactionBuilder;
import org.banks.corebusinessrules.entities.transactions.paymentorders.PaymentOrder;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.repositories.BankRepository;

public class GlobalFinancialMessagingService {
    final private BankRepository bankRepository;
    final private CentralBankService centralBank;

    public GlobalFinancialMessagingService(BankRepository bankRepository, CentralBankService centralBank) {
        this.bankRepository = bankRepository;
        this.centralBank = centralBank;
    }

    public void ProcessPaymentOrder(PaymentOrder order) {
        TransactionBuilder builder = order.transactionBuilder();
        Bank bankReceiver = bankRepository.GetBankById(order.receiverBankId());
        Bank bankSender = bankRepository.GetBankById(order.senderBankId());

        centralBank.ProcessTransaction(builder.WithAmount(order.amount())
                .WithSender(bankSender, order.senderAccountId())
                .WithReceiver(bankReceiver, order.receiverAccountId())
                .Build());
    }
}
