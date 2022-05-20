package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetAllCustomerRepository implements GetAllCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public List<Customer> getAll(Pageable pageable, CustomerFilter customerFilter) {
        Specification<CustomerEntity> specification = customerFilter.getSpecification();
        return jpaCustomerRepository.findAll(specification, pageable)
                .map(CustomerEntity::toDomain)
                .toList();
    }
}
