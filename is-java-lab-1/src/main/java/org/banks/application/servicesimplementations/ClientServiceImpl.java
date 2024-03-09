package org.banks.application.servicesimplementations;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.accounts.CreditAccount;
import org.banks.corebusinessrules.accounts.DebitAccount;
import org.banks.corebusinessrules.accounts.DepositAccount;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.paymentorder.PaymentOrder;
import org.banks.corebusinessrules.services.ports.ClientService;
import org.banks.corebusinessrules.services.repositories.BankRepository;
import org.banks.corebusinessrules.services.transactions.builders.RefillTransactionBuilder;
import org.banks.corebusinessrules.services.transactions.builders.TransferTransactionBuilder;
import org.banks.corebusinessrules.services.transactions.builders.WithdrawTransactionBuilder;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final BankRepository bankRepository;
    private Bank currentBank;
    private Optional<UUID> currentAccount;
    @Override
    public void ChooseBank(UUID bankId) {
        currentBank = bankRepository.GetBankById(bankId);
    }

    @Override
    public void LogIntoAccount(UUID accountId, String password) {
        if(currentBank != null) {
            this.currentAccount = currentBank.LoginIntoAccount(accountId, password);
        }
    }

    @Override
    public void CreateAccount(Account account) {
        if(this.currentBank != null) {
            this.currentBank.AddAccount(account);
        }
    }

    @Override
    public void SendWithdrawOrder(BigDecimal amount) {
        if(this.currentAccount.isPresent() && this.currentBank != null) {
            this.currentBank.ProcessPaymentOrder(new PaymentOrder(new WithdrawTransactionBuilder(), this.currentBank.getId(), this.currentAccount.get(), this.currentBank.getId(), this.currentAccount.get(), amount));
        }
    }

    @Override
    public void SendRefillOrder(BigDecimal amount) {
        if(this.currentAccount.isPresent() && this.currentBank != null) {
            this.currentBank.ProcessPaymentOrder(new PaymentOrder(new RefillTransactionBuilder(), this.currentBank.getId(), this.currentAccount.get(), this.currentBank.getId(), this.currentAccount.get(), amount));
        }
    }

    @Override
    public void SendTransferOrder(UUID destBankId, UUID destAccountId, BigDecimal amount) {
        if(this.currentAccount.isPresent() && this.currentBank != null) {
            this.currentBank.ProcessPaymentOrder(new PaymentOrder(new TransferTransactionBuilder(), this.currentBank.getId(), this.currentAccount.get(), destBankId, destAccountId, amount));
        }
    }
}
