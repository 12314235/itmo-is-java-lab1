package org.banks.corebusinessrules.accounts.percentage;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * Implementation of PercentageStrategy for debit accounts.
 */
@RequiredArgsConstructor
public class DebitPercentage implements PercentageStrategy {
    final private BigDecimal percentage;

    /**
     * Calculates the percentage based on the current balance for debit accounts.
     * The method returns the current balance multiplied by the percentage.
     *
     * @param currentBalance The current balance to calculate the percentage for.
     * @return The calculated percentage.
     */
    @Override
    public BigDecimal doPercentageCalculations(BigDecimal currentBalance) {
        return currentBalance.add(currentBalance.multiply(this.percentage));
    }
}
