package org.banks.corebusinessrules.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Admin {
    private final UUID id;
    private final String password;

}
