package org.banks.corebusinessrules.services.timemanager;

import org.banks.corebusinessrules.accounts.Account;
import org.banks.corebusinessrules.services.timemanager.observers.TimeManagerObserver;

public interface TimeManager {
    public void SkipDays(int count);
    public boolean IsFirstDayOfMonth();
    public void NotifyAccounts();
    public void AddObservers(TimeManagerObserver account);
}
