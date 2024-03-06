package org.banks.corebusinessrules.services.timemanager.observers;

import java.time.LocalDateTime;

public interface TimeManagerObserver {
    public void ReactToTimeChange(LocalDateTime time);
}
