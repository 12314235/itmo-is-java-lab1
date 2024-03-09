package org.banks.datalayer;

import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.services.repositories.AdminsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InMemoryAdminRepositoryImpl implements AdminsRepository {
    private final HashMap<UUID, Admin> admins = new HashMap<>();

    @Override
    public Admin getAdminById(UUID id) {
        return admins.get(id);
    }

    @Override
    public void createAdmin(Admin admin) {
        admins.put(admin.getId(), admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        admins.put(admin.getId(), admin);
    }

    @Override
    public void deleteAdminById(UUID id) {
        admins.remove(id);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        admins.remove(admin.getId());
    }

    @Override
    public List<Admin> getListOfAdmins() {
        return new ArrayList<>(admins.values());
    }
}
