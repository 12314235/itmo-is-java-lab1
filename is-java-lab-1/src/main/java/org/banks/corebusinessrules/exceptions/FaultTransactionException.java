package org.banks.corebusinessrules.exceptions;

public class FaultTransactionException extends Exception {
    public FaultTransactionException() {
    }

    public FaultTransactionException(String message) {
        super(message);
    }

    public FaultTransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FaultTransactionException(Throwable cause) {
        super(cause);
    }

    public FaultTransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
