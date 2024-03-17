package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.models.Client;

import java.util.List;
import java.util.UUID;

public interface ClientRepository {
    public Client getClientById(UUID id);

    public void createClient(Client client);

    public void updateClient(Client client);

    public void deleteClientById(UUID id);

    public void deleteClient(Client client);

    public List<Client> getListOfClients();
}
