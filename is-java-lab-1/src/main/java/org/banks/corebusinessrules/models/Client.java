package org.banks.corebusinessrules.models;

import lombok.Data;

import java.util.Optional;
import java.util.UUID;

@Data
public class Client {
    private final UUID id;
    private final String name;
    private final String surname;
    private Optional<String> address;
    private Optional<String> password;
}
