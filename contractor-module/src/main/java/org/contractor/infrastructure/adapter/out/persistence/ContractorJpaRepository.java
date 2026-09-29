package org.contractor.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ContractorJpaRepository extends JpaRepository<ContractorDbEntity, UUID> {
    boolean existsByTaxId(String taxId);
}
