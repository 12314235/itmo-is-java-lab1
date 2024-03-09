package org.banks.corebusinessrules.services.ports;

import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.bank.Bank;

import java.util.UUID;

public interface AdminService {
    public void createBank(Bank bank);
    public void updatePercentageStrategy(UUID bankId, PercentageStrategy newStrategy);
}
