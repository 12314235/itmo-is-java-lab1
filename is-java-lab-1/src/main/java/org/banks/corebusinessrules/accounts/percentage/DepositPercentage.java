package org.banks.corebusinessrules.accounts.percentage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class DepositPercentage implements PercentageStrategy {
    private final Map<BigDecimal, BigDecimal> balancePercentagePairs;
    private final BigDecimal lastPercentage;

    public DepositPercentage(TreeMap<BigDecimal, BigDecimal> balancePercentagePairs, BigDecimal lastPercentage) {
        this.balancePercentagePairs = balancePercentagePairs;
        this.lastPercentage = lastPercentage;
    }

    public BigDecimal DoPercentageCalculations(BigDecimal currentBalance) {
        for (BigDecimal key : balancePercentagePairs.keySet()) {
            if (key.compareTo(currentBalance) >= 0) {
                return currentBalance.add(currentBalance.multiply(balancePercentagePairs.get(key)));
            }
        }

        return currentBalance.add(currentBalance.multiply(this.lastPercentage));
    }
}
