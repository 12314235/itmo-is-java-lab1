package org.banks.corebusinessrules.services.ports;

import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.models.Client;

import java.util.UUID;

public interface LoginService {
    public Admin adminLogin(UUID id, String password);
    public Client clientLogin(UUID id, String password);
}
