package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.application.persistence.GetCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetCustomerRepository implements GetCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public CustomerEntity getById(Long id) {
        Optional<CustomerEntity> customer = jpaCustomerRepository.findById(id);

        return customer.orElseThrow(() -> new NotFoundException("Customer", id));
    }
}
