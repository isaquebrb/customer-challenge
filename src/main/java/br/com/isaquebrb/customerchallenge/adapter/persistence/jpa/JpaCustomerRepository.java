package br.com.isaquebrb.customerchallenge.adapter.persistence.jpa;

import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {
}
