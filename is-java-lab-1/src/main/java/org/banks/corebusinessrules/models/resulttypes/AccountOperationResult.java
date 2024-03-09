package org.banks.corebusinessrules.models.resulttypes;

import java.util.UUID;

public record AccountOperationResult(UUID accountId, String message, ResultStatus status) {
}
