package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.application.mapper.CustomerMapper;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.application.persistence.CreateCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class CreateCustomerRepository implements CreateCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public CustomerEntity save(Customer customerRequest) {
        CustomerEntity customerEntity = CustomerMapper.toEntity(customerRequest);

        customerEntity = jpaCustomerRepository.save(customerEntity);

        log.info("New customer id {} created", customerEntity.getId());
        return customerEntity;
    }
}
