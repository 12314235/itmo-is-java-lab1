package org.banks.datalayer;

import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.services.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InMemoryClientRepositoryImpl implements ClientRepository {
    private final HashMap<UUID, Client> clients = new HashMap<>();

    @Override
    public Client GetClientById(UUID id) {
        return clients.get(id);
    }

    @Override
    public void CreateClient(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void UpdateClient(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void DeleteClientById(UUID id) {
        clients.remove(id);
    }

    @Override
    public void DeleteClient(Client client) {
        clients.remove(client.getId());
    }

    @Override
    public List<Client> GetListOfClients() {
        return new ArrayList<>(clients.values());
    }
}