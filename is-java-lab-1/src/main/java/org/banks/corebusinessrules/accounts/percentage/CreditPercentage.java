package org.banks.corebusinessrules.accounts.percentage;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreditPercentage implements PercentageStrategy {
    private final BigDecimal percentage;

    @Override
    public BigDecimal DoPercentageCalculations(BigDecimal currentBalance) {
        if (currentBalance.compareTo(BigDecimal.ZERO) < 0) {
            return currentBalance.add(currentBalance.multiply(currentBalance));
        }

        return currentBalance;
    }
}
