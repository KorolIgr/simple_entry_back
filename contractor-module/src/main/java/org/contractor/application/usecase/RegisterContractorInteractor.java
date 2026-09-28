package org.contractor.application.usecase;

import org.contractor.application.port.in.RegisterContractorCommand;
import org.contractor.application.port.out.ContractorRepositoryPort;
import org.contractor.domain.model.Contractor;
import java.util.UUID;

public class RegisterContractorInteractor implements RegisterContractorUseCase {

    private final ContractorRepositoryPort repositoryPort;

    public RegisterContractorInteractor(ContractorRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public UUID register(RegisterContractorCommand command) {
        // 1. Проверяем бизнес-правило уникальности поставщика
        if (repositoryPort.existsByTaxId(command.taxId())) {
            throw new IllegalStateException("Поставщик с таким налоговым ID уже существует");
        }

        // 2. Создаем чистую доменную сущность (id сгенерируется внутри или будет null)
        Contractor contractor = new Contractor( command.name(), command.taxId());

        // 3. Сохраняем в базу данных через абстрактный порт
        Contractor savedContractor = repositoryPort.save(contractor);

        // 4. Возвращаем сгенерированный идентификатор
        return savedContractor.getId();
    }
}
