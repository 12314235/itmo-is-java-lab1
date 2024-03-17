package org.banks.corebusinessrules.accounts.percentage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of PercentageStrategy for deposit accounts.
 */
public class DepositPercentage implements PercentageStrategy {
    private final Map<BigDecimal, BigDecimal> balancePercentagePairs;
    private final BigDecimal lastPercentage;

    /**
     * Constructs a new DepositPercentage instance with the specified balance-percentage pairs and last percentage.
     *
     * @param balancePercentagePairs A map containing balance-percentage pairs where the key is the balance threshold and the value is the percentage.
     * @param lastPercentage         The percentage to be applied if the current balance exceeds all threshold values in the map.
     */
    public DepositPercentage(TreeMap<BigDecimal, BigDecimal> balancePercentagePairs, BigDecimal lastPercentage) {
        this.balancePercentagePairs = balancePercentagePairs;
        this.lastPercentage = lastPercentage;
    }

    /**
     * Calculates the percentage based on the current balance for deposit accounts.
     * The method iterates through the balance-percentage pairs and returns the percentage corresponding to the first threshold that the current balance exceeds.
     * If the current balance exceeds all threshold values, the method returns the last percentage.
     *
     * @param currentBalance The current balance to calculate the percentage for.
     * @return The calculated percentage.
     */
    public BigDecimal doPercentageCalculations(BigDecimal currentBalance) {
        for (BigDecimal key : balancePercentagePairs.keySet()) {
            if (key.compareTo(currentBalance) >= 0) {
                return currentBalance.add(currentBalance.multiply(balancePercentagePairs.get(key)));
            }
        }

        return currentBalance.add(currentBalance.multiply(this.lastPercentage));
    }
}
