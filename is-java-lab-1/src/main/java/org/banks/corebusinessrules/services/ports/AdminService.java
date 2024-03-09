package org.banks.corebusinessrules.services.ports;

import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.bank.Bank;

import java.util.UUID;

public interface AdminService {
    public void CreateBank(Bank bank);
    public void UpdatePercentageStrategy(UUID bankId, PercentageStrategy newStrategy);
}
