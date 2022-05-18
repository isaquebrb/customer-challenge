package br.com.isaquebrb.customerchallenge.core.persistence;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface GetAllCustomerPersistence {

    Page<CustomerEntity> getAll(Pageable pageable, Specification<CustomerEntity> specification);
}
