package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import br.com.isaquebrb.customerchallenge.core.persistence.UpdateCustomerPersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateCustomerRepository implements UpdateCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public void update(Long customerId, String name, Integer age, String cellphone, String phone) {
        CustomerEntity customerEntity = getCustomerEntity(customerId);
        customerEntity.update(name, age, cellphone, phone);
        updateCustomer(customerEntity);
    }

    @Override
    public void updateEmail(Long customerId, String email) {
        CustomerEntity customerEntity = getCustomerEntity(customerId);
        customerEntity.updateEmail(email);
        updateCustomer(customerEntity);
    }

    @Override
    public void updateActivation(Long customerId, boolean active) {
        CustomerEntity customerEntity = getCustomerEntity(customerId);
        customerEntity.updateActivation(active);
        updateCustomer(customerEntity);
        log.info("Customer id [{}] {}.", customerId, active ? "activated" : "disabled");
    }

    private CustomerEntity getCustomerEntity(Long id) {
        return jpaCustomerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer", id));
    }

    private void updateCustomer(CustomerEntity customerEntity) {
        jpaCustomerRepository.save(customerEntity);
        log.info("Customer id [{}] updated successfully", customerEntity.getId());
    }
}
