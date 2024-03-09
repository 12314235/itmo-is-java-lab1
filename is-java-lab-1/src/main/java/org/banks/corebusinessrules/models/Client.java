package org.banks.corebusinessrules.models;

import lombok.Data;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents a client entity in the banking system.
 */
@Data
public class Client {
    /**
     * The unique identifier of the client.
     */
    private final UUID id;

    /**
     * The name of the client.
     */
    private final String name;

    /**
     * The surname of the client.
     */
    private final String surname;

    /**
     * The address of the client (optional).
     */
    private Optional<String> address;

    /**
     * The password of the client (optional).
     */
    private final String password;
}
