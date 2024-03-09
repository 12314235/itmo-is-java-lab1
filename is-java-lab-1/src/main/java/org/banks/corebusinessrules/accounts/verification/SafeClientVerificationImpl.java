package org.banks.corebusinessrules.accounts.verification;

import java.math.BigDecimal;

/**
 * Implementation of VerificationStrategy for safe client verification.
 * This implementation always returns true, indicating that all operations are verified.
 */
public class SafeClientVerificationImpl implements VerificationStrategy {

    /**
     * Checks if the operation is verified for safe clients.
     * Since this implementation always returns true, it indicates that all operations are verified.
     *
     * @param limit  The limit for the operation.
     * @param amount The amount of the operation.
     * @return true indicating the operation is verified.
     */
    @Override
    public boolean isVerificatedOperation(BigDecimal limit, BigDecimal amount) {
        return true;
    }
}
