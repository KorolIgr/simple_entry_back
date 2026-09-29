package org.contractor.application.port.out;

import org.contractor.domain.model.Contractor;
import java.util.Optional;

public interface ContractorRepositoryPort {
    boolean existsByTaxId(String taxId);
    Contractor save(Contractor contractor);
}
