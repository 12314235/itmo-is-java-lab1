package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.bank.Bank;

import java.util.List;
import java.util.UUID;

public interface BankRepository {
    public Bank GetBankById(UUID id);
    public void CreateBank(Bank bank);
    public void UpdateBank(Bank bank);
    public void DeleteBankById(UUID id);
    public void DeleteBank(Bank bank);
    public List<Bank> GetListOfBanks();
}
