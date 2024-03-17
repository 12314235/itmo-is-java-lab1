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
    public Client getClientById(UUID id) {
        return clients.get(id);
    }

    @Override
    public void createClient(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void updateClient(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void deleteClientById(UUID id) {
        clients.remove(id);
    }

    @Override
    public void deleteClient(Client client) {
        clients.remove(client.getId());
    }

    @Override
    public List<Client> getListOfClients() {
        return new ArrayList<>(clients.values());
    }
}