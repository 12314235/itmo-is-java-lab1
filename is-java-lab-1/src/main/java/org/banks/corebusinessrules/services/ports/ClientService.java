package org.banks.corebusinessrules.services.ports;

import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.accounts.CreditAccount;
import org.banks.corebusinessrules.accounts.DebitAccount;
import org.banks.corebusinessrules.accounts.DepositAccount;

import java.math.BigDecimal;
import java.util.UUID;

public interface ClientService {
    public void ChooseBank(UUID bankId);
    public void LogIntoAccount(UUID accountId, String password);
    public void CreateAccount(Account account);
    public void SendWithdrawOrder(BigDecimal amount);
    public void SendRefillOrder(BigDecimal amount);
    public void SendTransferOrder(UUID destBankId, UUID destAccountId, BigDecimal amount);
}
