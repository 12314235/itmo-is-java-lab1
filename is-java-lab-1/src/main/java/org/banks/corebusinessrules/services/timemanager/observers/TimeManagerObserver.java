package org.banks.corebusinessrules.services.timemanager.observers;

import java.time.LocalDateTime;

/**
 * Represents an observer for changes in time managed by a TimeManager.
 */
public interface TimeManagerObserver {
    /**
     * Reacts to a change in time by the TimeManager.
     *
     * @param time The new LocalDateTime indicating the current time.
     */
    void reactToTimeChange(LocalDateTime time);
}
