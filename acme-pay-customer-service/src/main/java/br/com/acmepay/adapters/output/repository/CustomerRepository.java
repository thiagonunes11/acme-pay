package br.com.acmepay.adapters.output.repository;

import br.com.acmepay.adapters.output.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByDocument(String document);
}
