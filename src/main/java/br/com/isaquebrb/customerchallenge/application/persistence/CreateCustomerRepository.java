package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.persistence.CreateCustomerPersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class CreateCustomerRepository implements CreateCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Customer save(Customer customerRequest) {
        CustomerEntity customerEntity = customerRequest.newEntity();
        customerEntity = jpaCustomerRepository.save(customerEntity);

        log.info("New customer id {} created", customerEntity.getId());
        return customerEntity.toDomain();
    }
}
