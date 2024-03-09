package org.banks.datalayer;

import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.services.repositories.BankRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * An in-memory implementation of the {@link BankRepository} interface.
 * This repository stores banks in a HashMap in memory.
 */
public class InMemoryBankRepositoryImpl implements BankRepository {
    private HashMap<UUID, Bank> banks = new HashMap<>();

    /**
     * Retrieves a bank by its unique identifier.
     *
     * @param id The unique identifier of the bank.
     * @return The bank with the specified identifier, or null if not found.
     */
    @Override
    public Bank getBankById(UUID id) {
        return banks.get(id);
    }

    /**
     * Creates a new bank in the repository.
     *
     * @param bank The bank to be created.
     */
    @Override
    public void createBank(Bank bank) {
        banks.put(bank.getId(), bank);
    }

    /**
     * Updates an existing bank in the repository.
     *
     * @param bank The bank to be updated.
     */
    @Override
    public void updateBank(Bank bank) {
        banks.put(bank.getId(), bank);
    }

    /**
     * Deletes a bank from the repository by its unique identifier.
     *
     * @param id The unique identifier of the bank to be deleted.
     */
    @Override
    public void deleteBankById(UUID id) {
        banks.remove(id);
    }

    /**
     * Deletes a bank from the repository.
     *
     * @param bank The bank to be deleted.
     */
    @Override
    public void deleteBank(Bank bank) {
        banks.remove(bank.getId());
    }

    /**
     * Retrieves a list of all banks stored in the repository.
     *
     * @return A list of all banks stored in the repository.
     */
    @Override
    public List<Bank> getListOfBanks() {
        return new ArrayList<>(banks.values());
    }
}