package org.banks.corebusinessrules.accounts;

import org.banks.corebusinessrules.accounts.percentage.CreditPercentage;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.accounts.percentage.DepositPercentage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DepositAccount extends Account {
    public DepositAccount(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, DepositPercentage percentage, LocalDateTime accountTerm) {
        super(id, currentTime, owner, password, limit, verificationStrategy, percentage);
        this.accountTerm = accountTerm;
    }

    private final LocalDateTime accountTerm;


    @Override
    public boolean IsRefillPossible(BigDecimal amount) {
        return accountTerm.isBefore(this.currentTime);
    }

    @Override
    public boolean IsWithdrawPossible(BigDecimal amount) {
        return accountTerm.isBefore(this.currentTime);
    }

    @Override
    public void ReactToTimeChange(LocalDateTime time) {
        this.currentTime = time;
        if(this.currentTime.getDayOfMonth() == 1) {
            this.UpdateBalance();
        }
    }

    @Override
    public void ReactToPercentageStrategyChange(PercentageStrategy percentage) {
        if (percentage instanceof DepositPercentage) {
            this.percentage = percentage;
        }
    }
}
