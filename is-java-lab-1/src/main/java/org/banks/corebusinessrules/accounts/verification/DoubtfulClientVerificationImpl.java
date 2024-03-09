package org.banks.corebusinessrules.accounts.verification;

import java.math.BigDecimal;

/**
 * Implementation of VerificationStrategy for doubtful client verification.
 * This implementation checks if the amount of the operation is less than or equal to the specified limit.
 */
public class DoubtfulClientVerificationImpl implements VerificationStrategy {

    /**
     * Checks if the operation is verified for doubtful clients.
     * This implementation checks if the amount of the operation is less than or equal to the specified limit.
     *
     * @param limit  The limit for the operation.
     * @param amount The amount of the operation.
     * @return true if the operation is verified, false otherwise.
     */
    @Override
    public boolean isVerificatedOperation(BigDecimal limit, BigDecimal amount) {
        return amount.compareTo(limit) <= 0;
    }
}
