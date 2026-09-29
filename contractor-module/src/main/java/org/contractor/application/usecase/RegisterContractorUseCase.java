package org.contractor.application.usecase;

import org.contractor.application.port.in.RegisterContractorCommand;
import java.util.UUID;

public interface RegisterContractorUseCase {
    UUID register(RegisterContractorCommand command);
}
