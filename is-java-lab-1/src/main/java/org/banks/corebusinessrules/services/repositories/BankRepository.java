package org.banks.corebusinessrules.services.repositories;

import org.banks.corebusinessrules.bank.Bank;

import java.util.List;
import java.util.UUID;

/**
 * Represents a repository interface for managing banks.
 */
public interface BankRepository {
    /**
     * Retrieves a bank by its ID.
     *
     * @param id The ID of the bank.
     * @return The bank with the specified ID, or null if not found.
     */
    public Bank GetBankById(UUID id);

    /**
     * Creates a new bank.
     *
     * @param bank The bank to create.
     */
    public void CreateBank(Bank bank);

    /**
     * Updates an existing bank.
     *
     * @param bank The bank to update.
     */
    public void UpdateBank(Bank bank);

    /**
     * Deletes a bank by its ID.
     *
     * @param id The ID of the bank to delete.
     */
    public void DeleteBankById(UUID id);

    /**
     * Deletes a bank.
     *
     * @param bank The bank to delete.
     */
    public void DeleteBank(Bank bank);

    /**
     * Retrieves a list of all banks.
     *
     * @return The list of banks.
     */
    public List<Bank> GetListOfBanks();
}
