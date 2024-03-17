package org.banks.corebusinessrules.services.timemanager;

import lombok.Getter;
import org.banks.corebusinessrules.services.timemanager.observers.TimeManagerObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a default implementation of the TimeManager interface.
 */
public class DefaultTimeManagerImpl implements TimeManager {
    @Getter
    private LocalDateTime time;
    private List<TimeManagerObserver> observers = new ArrayList<>();

    /**
     * Constructs a DefaultTimeManagerImpl object with the given initial time.
     *
     * @param time The initial time.
     */
    public DefaultTimeManagerImpl(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public void skipDays(int count) {
        time = time.plusDays(count);
    }

    @Override
    public boolean isFirstDayOfMonth() {
        return time.getDayOfMonth() == 1;
    }

    @Override
    public void notifyAccounts() {
        for (TimeManagerObserver observer : observers) {
            observer.reactToTimeChange(this.time);
        }
    }

    @Override
    public void addObservers(TimeManagerObserver account) {
        observers.add(account);
    }

    @Override
    public LocalDateTime getCurrentTime() {
        return this.time;
    }
}
