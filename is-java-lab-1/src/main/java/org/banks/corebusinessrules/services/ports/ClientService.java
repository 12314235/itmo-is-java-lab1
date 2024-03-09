package org.banks.corebusinessrules.services.ports;

import org.banks.corebusinessrules.accounts.Account;

import java.math.BigDecimal;
import java.util.UUID;

public interface ClientService {
    public void chooseBank(UUID bankId);
    public void logIntoAccount(UUID accountId, String password);
    public void createAccount(Account account);
    public void sendWithdrawOrder(BigDecimal amount);
    public void sendRefillOrder(BigDecimal amount);
    public void sendTransferOrder(UUID destBankId, UUID destAccountId, BigDecimal amount);
}
