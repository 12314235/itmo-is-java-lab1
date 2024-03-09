package org.banks.corebusinessrules.accounts.percentage;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * Implementation of PercentageStrategy for credit accounts.
 */
@RequiredArgsConstructor
public class CreditPercentage implements PercentageStrategy {
    private final BigDecimal percentage;

    /**
     * Calculates the percentage based on the current balance for credit accounts.
     * If the current balance is negative, the method returns the balance multiplied by itself.
     * If the current balance is positive or zero, the method returns the current balance unchanged.
     *
     * @param currentBalance The current balance to calculate the percentage for.
     * @return The calculated percentage.
     */
    @Override
    public BigDecimal DoPercentageCalculations(BigDecimal currentBalance) {
        if (currentBalance.compareTo(BigDecimal.ZERO) < 0) {
            return currentBalance.add(currentBalance.multiply(currentBalance));
        }

        return currentBalance;
    }
}
