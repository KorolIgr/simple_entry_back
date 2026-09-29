package org.contractor.application.port.in;

// Используем компактный синтаксис record из современной Java
public record RegisterContractorCommand(String name, String taxId) {
    public RegisterContractorCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя поставщика не может быть пустым");
        }
        if (taxId == null || taxId.isBlank()) {
            throw new IllegalArgumentException("Налоговый ID обязателен");
        }
    }
}