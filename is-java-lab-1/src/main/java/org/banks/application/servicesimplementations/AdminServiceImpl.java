package org.banks.application.servicesimplementations;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.services.ports.AdminService;
import org.banks.corebusinessrules.services.repositories.BankRepository;

import java.util.UUID;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final BankRepository bankRepository;
    @Override
    public void CreateBank(Bank bank) {
        this.bankRepository.CreateBank(bank);
    }

    @Override
    public void UpdatePercentageStrategy(UUID bankId, PercentageStrategy newStrategy) {
        Bank bank = bankRepository.GetBankById(bankId);
        if(bank != null) {
            bank.UpdatePercentageStrategy(newStrategy);
        }
    }
}
