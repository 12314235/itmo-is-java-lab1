package org.banks.corebusinessrules.services.timemanager;


import lombok.Getter;
import org.banks.corebusinessrules.services.timemanager.observers.TimeManagerObserver;

import java.time.LocalDateTime;
import java.util.List;

public class DefaultTimeManagerImpl implements TimeManager {
    @Getter private LocalDateTime time;
    private List<TimeManagerObserver> observers;

    public DefaultTimeManagerImpl(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public void SkipDays(int count) {
        time = time.plusDays(count);
    }

    @Override
    public boolean IsFirstDayOfMonth() {
        return time.getDayOfMonth() == 1;
    }

    @Override
    public void NotifyAccounts() {
        for(TimeManagerObserver observer : observers) {
            observer.ReactToTimeChange(this.time);
        }
    }

    @Override
    public void AddObservers(TimeManagerObserver account) {
        observers.add(account);
    }
}
