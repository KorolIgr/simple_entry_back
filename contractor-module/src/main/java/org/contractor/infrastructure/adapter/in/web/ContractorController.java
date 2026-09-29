package org.contractor.infrastructure.adapter.in.web;

import org.contractor.application.port.in.RegisterContractorCommand;
import org.contractor.application.usecase.RegisterContractorUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contractors")
public class ContractorController {

    private final RegisterContractorUseCase registerContractorUseCase;

    public ContractorController(RegisterContractorUseCase registerContractorUseCase) {
        this.registerContractorUseCase = registerContractorUseCase;
    }

    @PostMapping
    public ResponseEntity<UUID> registerContractor(@RequestBody RegisterContractorRequest request) {
        // Создаем валидируемую команду (входной порт)
        RegisterContractorCommand command = new RegisterContractorCommand(
                request.name(),
                request.taxId()
        );

        // Вызываем сценарий использования
        UUID contractorId = registerContractorUseCase.register(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(contractorId);
    }

    // Внутренний Record для HTTP Request DTO
    public record RegisterContractorRequest(String name, String taxId) {}
}
