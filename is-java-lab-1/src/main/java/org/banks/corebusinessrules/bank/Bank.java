package org.banks.corebusinessrules.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.models.paymentorder.PaymentOrder;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.globalfinancialmessagingservice.GlobalFinancialMessagingService;
import org.banks.corebusinessrules.services.timemanager.TimeManager;
import org.banks.corebusinessrules.services.transactions.builders.TransactionBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class Bank {
    @Getter
    private final UUID id;
    private final GlobalFinancialMessagingService globalFinancialMessagingService;
    private final TimeManager timeManager;
    private List<Account> accounts;
    private List<Client> subscribers;
    private List<Client> clients;


    public void AddAccount(Account account) {
        accounts.add(account);
        timeManager.AddObservers(account);
    }

    public void AddSubscriber(Client client) {
        subscribers.add(client);
    }

    public void AddClient(Client client) {
        clients.add(client);
    }

    public Optional<UUID> LoginIntoAccount(UUID id, String password) {
        Optional<Account> account = this.accounts.stream()
                .filter(acc -> acc.getId().equals(id))
                .findFirst();

        if(account.isEmpty()) {
            return Optional.empty();
        }

        if(!account.get().CheckPassword(password)) {
            return Optional.empty();
        }

        return Optional.of(account.get().getId());
    }

    public void ProcessPaymentOrder(PaymentOrder order) {
        globalFinancialMessagingService.ProcessPaymentOrder(order);
    }

    public void GetSenderAccount(TransactionBuilder builder, UUID accountId) throws ClassNotFoundException {
        Optional<Account> account = accounts.stream()
                        .filter(acc -> acc.getId().equals(accountId))
                        .findFirst();

        if(account.isEmpty()) {
            throw new ClassNotFoundException("Wrong account id");
        }
        else {
            builder.WithSender(account.get());
        }
    }

    public void GetReceiverAccount(TransactionBuilder builder, UUID accountId) throws ClassNotFoundException {
        Optional<Account> account = accounts.stream()
                .filter(acc -> acc.getId().equals(accountId))
                .findFirst();

        if(account.isEmpty()) {
            throw new ClassNotFoundException("Wrong account id");
        }
        else {
            builder.WithReceiver(account.get());
        }
    }
}
