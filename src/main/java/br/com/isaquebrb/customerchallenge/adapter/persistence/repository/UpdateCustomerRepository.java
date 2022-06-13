package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.UpdateCustomerPersistence;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateCustomerRepository implements UpdateCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final GetCustomerRepository getCustomerRepository;

    @Override
    public void update(Long customerId, String name, Integer age, String cellphone, String phone) {
        CustomerEntity customerEntity = getCustomerRepository.getById(customerId);
        customerEntity.update(name, age, cellphone, phone);
        updateCustomer(customerEntity);
    }

    @Override
    public void updateEmail(Long customerId, String email) {
        CustomerEntity customerEntity = getCustomerRepository.getById(customerId);
        customerEntity.updateEmail(email);
        updateCustomer(customerEntity);
    }

    @Override
    public void updateActivation(Long customerId, boolean active) {
        CustomerEntity customerEntity = getCustomerRepository.getById(customerId);
        customerEntity.updateActivation(active);
        updateCustomer(customerEntity);
        log.info("Customer id [{}] {}.", customerId, active ? "activated" : "disabled");
    }

    private void updateCustomer(CustomerEntity customerEntity) {
        jpaCustomerRepository.save(customerEntity);
        log.info("Customer id [{}] updated successfully", customerEntity.getId());
    }
}
