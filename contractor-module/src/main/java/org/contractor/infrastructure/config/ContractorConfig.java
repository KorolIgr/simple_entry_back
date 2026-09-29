package org.contractor.infrastructure.config;

import org.contractor.application.port.out.ContractorRepositoryPort;
import org.contractor.application.usecase.RegisterContractorInteractor;
import org.contractor.application.usecase.RegisterContractorUseCase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.contractor.infrastructure.adapter.out.persistence")
@EntityScan(basePackages = "org.contractor.infrastructure.adapter.out.persistence")
public class ContractorConfig {

    @Bean
    public RegisterContractorUseCase registerContractorUseCase(ContractorRepositoryPort repositoryPort) {
        return new RegisterContractorInteractor(repositoryPort);
    }
}
