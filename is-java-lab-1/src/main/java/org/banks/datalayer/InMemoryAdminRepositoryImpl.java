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
    public Admin GetAdminById(UUID id) {
        return admins.get(id);
    }

    @Override
    public void CreateAdmin(Admin admin) {
        admins.put(admin.getId(), admin);
    }

    @Override
    public void UpdateAdmin(Admin admin) {
        admins.put(admin.getId(), admin);
    }

    @Override
    public void DeleteAdminById(UUID id) {
        admins.remove(id);
    }

    @Override
    public void DeleteAdmin(Admin admin) {
        admins.remove(admin.getId());
    }

    @Override
    public List<Admin> GetListOfAdmins() {
        return new ArrayList<>(admins.values());
    }
}
