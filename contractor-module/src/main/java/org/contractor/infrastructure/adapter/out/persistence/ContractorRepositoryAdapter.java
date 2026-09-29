package org.contractor.infrastructure.adapter.out.persistence;

import org.contractor.application.port.out.ContractorRepositoryPort;
import org.contractor.domain.model.Contractor;
import org.springframework.stereotype.Repository; // Можно использовать @Repository вместо @Component

@Repository
public class ContractorRepositoryAdapter implements ContractorRepositoryPort {

    private final ContractorJpaRepository jpaRepository;

    public ContractorRepositoryAdapter(ContractorJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsByTaxId(String taxId) {
        return jpaRepository.existsByTaxId(taxId);
    }

    @Override
    public Contractor save(Contractor contractor) {
        // Конвертируем Домен -> Сущность БД
        ContractorDbEntity dbEntity = new ContractorDbEntity(
                contractor.getId(),
                contractor.getName(),
                contractor.getTaxId(),
                contractor.isActive()
        );

        ContractorDbEntity savedEntity = jpaRepository.save(dbEntity);

        // Конвертируем Сущность БД обратно в Домен
        return new Contractor(
                savedEntity.getName(),
                savedEntity.getTaxId()
        );
    }
}
