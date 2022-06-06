package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.application.mapper.CustomerMapper;
import br.com.isaquebrb.customerchallenge.application.persistence.CreateCustomerPersistence;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CreateCustomerPersistence createCustomerPersistence;

    @Override
    public Customer create(Customer customerRequest) {
        log.info("Creating new customer");

        CustomerEntity customerEntity = createCustomerPersistence.save(customerRequest);

        return CustomerMapper.toDomain(customerEntity);
    }
}
