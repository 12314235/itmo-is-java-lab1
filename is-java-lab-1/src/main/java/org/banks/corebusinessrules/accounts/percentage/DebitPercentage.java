package org.banks.corebusinessrules.accounts.percentage;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@RequiredArgsConstructor
public class DebitPercentage implements PercentageStrategy {
    final private BigDecimal percentage;

    @Override
    public BigDecimal DoPercentageCalculations(BigDecimal currentBalance) {
        return currentBalance.add(currentBalance.multiply(this.percentage));
    }
}
