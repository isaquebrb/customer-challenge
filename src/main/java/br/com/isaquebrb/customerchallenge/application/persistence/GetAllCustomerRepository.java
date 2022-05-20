package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetAllCustomerRepository implements GetAllCustomerPersistence {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Page<CustomerEntity> getAll(Pageable pageable, Specification<CustomerEntity> specification) {
        return jpaCustomerRepository.findAll(specification, pageable);
    }
}
