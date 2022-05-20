package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import br.com.isaquebrb.customerchallenge.core.persistence.GetCustomerPersistence;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetCustomerRepository implements GetCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Customer getById(Long id) {
        Optional<CustomerEntity> customer = jpaCustomerRepository.findById(id);

        return customer.map(CustomerEntity::toDomain)
                .orElseThrow(() -> new NotFoundException("Customer", id));
    }
}
