package org.contractor.domain.model;

import java.util.UUID;

public class Contractor {
    private final UUID id;
    private final String name;
    private final String taxId;
    private final boolean active;


    public Contractor(String name, String taxId) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя поставщика не может быть пустым");
        }
        if (taxId == null || taxId.isBlank()) {
            throw new IllegalArgumentException("Налоговый идентификатор (ИНН/БИН) обязателен");
        }

        this.id =  UUID.randomUUID();
        this.name = name;
        this.taxId = taxId;
        this.active = true;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getTaxId() { return taxId; }
    public boolean isActive() { return active; }
}
