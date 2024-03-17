package org.banks.corebusinessrules.services.timemanager;

import org.banks.corebusinessrules.services.timemanager.observers.TimeManagerObserver;

import java.time.LocalDateTime;

/**
 * Represents a time manager interface for managing time-related operations.
 */
public interface TimeManager {
    /**
     * Skips a specified number of days.
     *
     * @param count The number of days to skip.
     */
    public void skipDays(int count);

    /**
     * Checks if the current date is the first day of the month.
     *
     * @return true if it's the first day of the month, otherwise false.
     */
    public boolean isFirstDayOfMonth();

    /**
     * Notifies about time change all accounts registered as observers.
     */
    public void notifyAccounts();

    /**
     * Adds an observer to be notified by the time manager.
     *
     * @param account The observer account to add.
     */
    public void addObservers(TimeManagerObserver account);

    public LocalDateTime getCurrentTime();
}
