package org.banks.datalayer;

import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.services.repositories.BankRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InMemoryBankRepositoryImpl implements BankRepository {
    private HashMap<UUID, Bank> banks;

    @Override
    public Bank GetBankById(UUID id) {
        return banks.get(id);
    }

    @Override
    public void CreateBank(Bank bank) {
        banks.put(bank.getId(), bank);
    }

    @Override
    public void UpdateBank(Bank bank) {
        banks.put(bank.getId(), bank);
    }

    @Override
    public void DeleteBankById(UUID id) {
        banks.remove(id);
    }

    @Override
    public void DeleteBank(Bank bank) {
        banks.remove(bank.getId());
    }

    @Override
    public List<Bank> GetListOfBanks() {
        return new ArrayList<>(banks.values());
    }
}
