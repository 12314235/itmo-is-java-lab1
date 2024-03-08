package org.banks.corebusinessrules.bank;

import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;

public interface BankTermsListener {
    public void ReactToPercentageStrategyChange(PercentageStrategy percentage);
}
