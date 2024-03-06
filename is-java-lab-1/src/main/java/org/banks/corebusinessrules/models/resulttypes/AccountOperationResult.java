package org.banks.corebusinessrules.models.resulttypes;

import java.util.UUID;

public record AccountOperationResult(UUID accountId, String Message, ResultStatus status) {
}
