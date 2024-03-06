package org.banks.corebusinessrules.accounts.verification;

import java.math.BigDecimal;

public interface VerificationStrategy {
    public boolean IsVerificatedOperation(BigDecimal limit, BigDecimal amount);
}
