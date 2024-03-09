package org.banks.corebusinessrules.services.ports;

import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.models.Client;

import java.util.UUID;

public interface LoginService {
    public Admin AdminLogin(UUID id, String password);
    public Client ClientLogin(UUID id, String password);
}
