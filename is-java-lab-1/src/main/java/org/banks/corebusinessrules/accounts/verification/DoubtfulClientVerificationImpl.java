package org.banks.corebusinessrules.accounts.verification;

import java.math.BigDecimal;

public class DoubtfulClientVerificationImpl implements VerificationStrategy {
    @Override
    public boolean IsVerificatedOperation(BigDecimal limit, BigDecimal amount) {
        return amount.compareTo(limit) <= 0;
    }
}
