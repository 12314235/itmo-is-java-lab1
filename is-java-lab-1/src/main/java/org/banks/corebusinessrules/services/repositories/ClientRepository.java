package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.Client;

import java.util.List;
import java.util.UUID;

public interface ClientRepository {
    public Client GetClientById(UUID id);

    public void CreateClient(Client client);

    public void UpdateClient(Client client);

    public void DeleteClientById(UUID id);

    public void DeleteClient(Client client);

    public List<Client> GetListOfClients();
}
