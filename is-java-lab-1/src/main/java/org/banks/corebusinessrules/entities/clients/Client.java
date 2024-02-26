package org.banks.corebusinessrules.entities.clients;

import lombok.Getter;
import lombok.Setter;
import org.banks.corebusinessrules.models.Address;
import org.banks.corebusinessrules.models.PassportId;

@Getter
public class Client {
    final private String name;
    final private String surname;
    @Setter
    private Address address;
    @Setter
    private PassportId id;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Client(String name, String surname, Address address, PassportId id) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.id = id;
    }
}