package org.banks.corebusinessrules.bank;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.models.paymentorder.PaymentOrder;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.globalfinancialmessagingservice.GlobalFinancialMessagingService;
import org.banks.corebusinessrules.services.timemanager.TimeManager;
import org.banks.corebusinessrules.services.transactions.builders.TransactionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a bank entity.
 */
public class Bank {

    public Bank(UUID id, GlobalFinancialMessagingService globalFinancialMessagingService, TimeManager timeManager) {
        this.id = id;
        this.globalFinancialMessagingService = globalFinancialMessagingService;
        this.timeManager = timeManager;
        this.accounts = accounts;
        this.subscribers = subscribers;
        this.clients = clients;
    }

    @Getter
    private final UUID id;
    private final GlobalFinancialMessagingService globalFinancialMessagingService;
    private final TimeManager timeManager;
    private List<Account> accounts = new ArrayList<>();
    private List<Client> subscribers = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    /**
     * Adds a new account to the bank.
     * @param account The account to add.
     */
    public void AddAccount(Account account) {
        accounts.add(account);
        timeManager.AddObservers(account);
    }


    /**
     * Updates percentage calculation strategy.
     * @param percentageStrategy New percentage strategy.
     */
    public void UpdatePercentageStrategy(PercentageStrategy percentageStrategy) {
        for(Account acc : accounts) {
            acc.ReactToPercentageStrategyChange(percentageStrategy);
        }
    }

    /**
     * Adds a new subscriber to the bank.
     * @param client The subscriber to add.
     */
    public void AddSubscriber(Client client) {
        subscribers.add(client);
    }

    /**
     * Adds a new client to the bank.
     * @param client The client to add.
     */
    public void AddClient(Client client) {
        clients.add(client);
    }

    /**
     * Logs into the account with the specified ID and password.
     * @param id The ID of the account to log into.
     * @param password The password of the account.
     * @return An optional containing the ID of the logged-in account, or empty if login failed.
     */
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

    /**
     * Processes a payment order.
     * @param order The payment order to process.
     */
    public void ProcessPaymentOrder(PaymentOrder order) {
        globalFinancialMessagingService.ProcessPaymentOrder(order);
    }

    /**
     * Sets the sender account for a transaction.
     * @param builder The transaction builder.
     * @param accountId The ID of the sender account.
     * @throws ClassNotFoundException if the account with the specified ID is not found.
     */
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

    /**
     * Sets the receiver account for a transaction.
     * @param builder The transaction builder.
     * @param accountId The ID of the receiver account.
     * @throws ClassNotFoundException if the account with the specified ID is not found.
     */
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

    /// =^_^=
}