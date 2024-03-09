package org.banks.corebusinessrules.bank;

import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;

/**
 * Listener interface for reacting to changes in bank terms, such as percentage strategy changes.
 */
public interface BankTermsListener {

    /**
     * Reacts to a change in percentage strategy.
     * @param percentage The new percentage strategy.
     */
    public void ReactToPercentageStrategyChange(PercentageStrategy percentage);
}
