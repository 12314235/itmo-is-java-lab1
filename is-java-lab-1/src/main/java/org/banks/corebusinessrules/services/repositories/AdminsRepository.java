package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.Admin;

import java.util.List;
import java.util.UUID;

public interface AdminsRepository {
    public Admin GetAdminById(UUID id);

    public void CreateAdmin(Admin admin);

    public void UpdateAdmin(Admin admin);

    public void DeleteAdminById(UUID id);

    public void DeleteAdmin(Admin admin);

    public List<Admin> GetListOfAdmins();
}
