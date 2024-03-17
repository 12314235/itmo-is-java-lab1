package org.banks.corebusinessrules.accounts.verification;

import java.math.BigDecimal;

/**
 * Interface for defining verification strategies for account operations.
 */
public interface VerificationStrategy {

    /**
     * Checks if the operation is verified based on the specified limit and amount.
     *
     * @param limit  The limit for the operation.
     * @param amount The amount of the operation.
     * @return true if the operation is verified, false otherwise.
     */
    public boolean isVerificatedOperation(BigDecimal limit, BigDecimal amount);
}
