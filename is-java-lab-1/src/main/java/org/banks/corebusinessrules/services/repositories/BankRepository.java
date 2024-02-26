package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.entities.banks.Bank;

import java.util.List;

public interface BankRepository {
    public Bank GetBankById(long id);
    public void CreateBank(Bank bank);
    public void UpdateBank(Bank bank);
    public void DeleteBankById(long id);
    public void DeleteBank(Bank bank);
    public List<Bank> GetListOfBanks();
}
