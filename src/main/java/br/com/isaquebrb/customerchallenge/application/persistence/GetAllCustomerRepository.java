package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerSpecification;
import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.Page;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetAllCustomerRepository implements GetAllCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Page<Customer> getAll(Integer page, Integer size, CustomerFilter customerFilter) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<CustomerEntity> specification = CustomerSpecification.getSpecification(customerFilter);

        org.springframework.data.domain.Page<Customer> customersFoundPage =
                jpaCustomerRepository.findAll(specification, pageable)
                        .map(CustomerEntity::toDomain);

        return new Page<>(customersFoundPage.getContent(), customersFoundPage.getPageable().getPageNumber(),
                customersFoundPage.getPageable().getPageSize(), customersFoundPage.getTotalElements());
    }
}
