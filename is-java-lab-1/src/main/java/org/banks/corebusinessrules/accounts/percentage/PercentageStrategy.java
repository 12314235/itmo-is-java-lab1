package org.banks.corebusinessrules.accounts.percentage;

import java.math.BigDecimal;

public interface PercentageStrategy {
    public BigDecimal DoPercentageCalculations(BigDecimal currentBalance);
}
