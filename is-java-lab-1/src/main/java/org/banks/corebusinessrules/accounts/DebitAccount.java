package org.banks.corebusinessrules.accounts;

import lombok.Builder;
import lombok.Setter;
import org.banks.corebusinessrules.accounts.percentage.CreditPercentage;
import org.banks.corebusinessrules.accounts.percentage.DebitPercentage;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class DebitAccount extends Account {

    public DebitAccount(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, DebitPercentage percentage) {
        super(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }

    @Override
    public boolean IsRefillPossible(BigDecimal amount) {
        return true;
    }

    @Override
    public boolean IsWithdrawPossible(BigDecimal amount) {
        return amount.compareTo(amount) <= 0;
    }

    @Override
    public void ReactToTimeChange(LocalDateTime time) {
        this.currentTime = time;
        if (this.currentTime.getDayOfMonth() == 1) {
            this.UpdateBalance();
        }
    }

    @Override
    public void ReactToPercentageStrategyChange(PercentageStrategy percentage) {
        if (percentage instanceof DebitPercentage) {
            this.percentage = percentage;
        }
    }
}
