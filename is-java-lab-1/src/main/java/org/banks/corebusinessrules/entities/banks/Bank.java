package org.banks.corebusinessrules.entities.banks;

import lombok.Getter;
import org.banks.corebusinessrules.entities.accounts.Account;
import org.banks.corebusinessrules.services.globalfinancialmessagingservice.GlobalFinancialMessagingService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public class Bank {
    @Getter
    final private long id;
    final private GlobalFinancialMessagingService globalFinancialMessagingService;
    private List<Account> accounts;


    public Bank(long id, GlobalFinancialMessagingService globalFinancialMessagingService) {
        this.id = id;
        this.globalFinancialMessagingService = globalFinancialMessagingService;
    }

    public void WithdrawMoneyFromAccount(long accountId, BigDecimal amount) {
        Optional<Account> account = accounts.stream().filter(account1 -> account1.getId() == accountId).findFirst();
        if(account.isEmpty()) {
            // TODO result type
            return;
        }
        globalFinancialMessagingService.ProcessPaymentOrder(account.get().Withdraw(amount));
    }

    public void RefillMoneyOnAccount(long accountId, BigDecimal amount) {
        Optional<Account> account = accounts.stream().filter(account1 -> account1.getId() == accountId).findFirst();
        if(account.isEmpty()) {
            // TODO result type
            return;
        }
        globalFinancialMessagingService.ProcessPaymentOrder(account.get().Refill(amount));
    }

    public void TransferFromAccount(long accountId, BigDecimal amount, long receiverBankId, long receiverAccountId) {
        Optional<Account> account = accounts.stream().filter(account1 -> account1.getId() == accountId).findFirst();
        if(account.isEmpty()) {
            // TODO result type
            return;
        }
        globalFinancialMessagingService.ProcessPaymentOrder(account.get().Transfer(amount, receiverBankId, receiverAccountId));
    }

    public void RegisterAccount(Account account) {
        accounts.add(account);
    }
}
