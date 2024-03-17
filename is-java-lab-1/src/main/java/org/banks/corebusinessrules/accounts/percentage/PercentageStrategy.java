package org.banks.corebusinessrules.accounts.percentage;

import java.math.BigDecimal;

/**
 * Interface for defining percentage calculation strategies.
 */
public interface PercentageStrategy {

    /**
     * Calculates the percentage based on the current balance.
     * @param currentBalance The current balance to calculate the percentage for.
     * @return The calculated percentage.
     */
    public BigDecimal doPercentageCalculations(BigDecimal currentBalance);
}
