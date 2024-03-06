package org.banks.corebusinessrules.services.userservice;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.services.timemanager.TimeManager;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class BankService {
    private final TimeManager timeManager;
    private final Bank bank;
    private UUID accountId;

    public String Login(UUID id, String password) {
        Optional<UUID> account = bank.LoginIntoAccount(id, password);

        if(account.isEmpty()) {
            return "Login fault";
        }

        accountId = account.get();

        return "Login successful";
    }

    public S
}
