package org.banks.corebusinessrules.accounts.verification;

import java.math.BigDecimal;

public class SafeClientVerificationImpl implements VerificationStrategy {
    @Override
    public boolean IsVerificatedOperation(BigDecimal limit, BigDecimal amount) {
        return true;
    }
}
