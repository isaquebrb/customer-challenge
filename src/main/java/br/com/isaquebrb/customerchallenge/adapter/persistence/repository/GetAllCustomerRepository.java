package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerSpecification;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.GetAllCustomerPersistence;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class GetAllCustomerRepository implements GetAllCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Page<CustomerEntity> getAll(Integer page, Integer size, CustomerFilter customerFilter) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<CustomerEntity> specification = CustomerSpecification.getSpecification(customerFilter);

        Page<CustomerEntity> customersFoundPage =
                jpaCustomerRepository.findAll(specification, pageable);

        log.info("Selected customers {}, total found of {}", customersFoundPage.getContent().size(),
                customersFoundPage.getTotalElements());

        return customersFoundPage;
    }
}
