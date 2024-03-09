package org.banks.application.servicesimplementations;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.services.ports.LoginService;
import org.banks.corebusinessrules.services.repositories.AdminsRepository;
import org.banks.corebusinessrules.services.repositories.ClientRepository;

import java.util.UUID;

@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final ClientRepository clientRepository;
    private final AdminsRepository adminsRepository;


    @Override
    public Admin AdminLogin(UUID id, String password) {
        Admin admin = adminsRepository.GetAdminById(id);
        if(admin.getPassword().equals(password)) {
            return admin;
        }

        return null;
    }

    @Override
    public Client ClientLogin(UUID id, String password) {
        Client client = clientRepository.GetClientById(id);
        if(client.getPassword().equals(password)) {
            return client;
        }

        return null;
    }
}
