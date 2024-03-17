package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.models.Admin;

import java.util.List;
import java.util.UUID;

public interface AdminsRepository {
    public Admin getAdminById(UUID id);

    public void createAdmin(Admin admin);

    public void updateAdmin(Admin admin);

    public void deleteAdminById(UUID id);

    public void deleteAdmin(Admin admin);

    public List<Admin> getListOfAdmins();
}
