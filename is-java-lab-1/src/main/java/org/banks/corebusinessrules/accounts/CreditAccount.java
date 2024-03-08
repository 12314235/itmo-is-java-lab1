package org.banks.corebusinessrules.accounts;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.banks.corebusinessrules.accounts.percentage.CreditPercentage;
import org.banks.corebusinessrules.accounts.percentage.PercentageStrategy;
import org.banks.corebusinessrules.accounts.verification.VerificationStrategy;
import org.banks.corebusinessrules.models.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class CreditAccount extends Account {
    public CreditAccount(UUID id, LocalDateTime currentTime, Client owner, String password, BigDecimal limit, VerificationStrategy verificationStrategy, CreditPercentage percentage) {
        super(id, currentTime, owner, password, limit, verificationStrategy, percentage);
    }

    @Override
    public boolean IsRefillPossible(BigDecimal amount) {
        return true;
    }

    @Override
    public boolean IsWithdrawPossible(BigDecimal amount) {
        return true;
    }

    @Override
    public void ReactToTimeChange(LocalDateTime time) {

    }

    @Override
    public void ReactToPercentageStrategyChange(PercentageStrategy percentage) {
        if (percentage instanceof CreditPercentage) {
            this.percentage = percentage;
        }
    }
}
