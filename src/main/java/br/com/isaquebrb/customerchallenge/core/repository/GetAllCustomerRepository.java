package br.com.isaquebrb.customerchallenge.core.repository;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface GetAllCustomerRepository {

    Page<CustomerEntity> getAll(Pageable pageable, Specification<CustomerEntity> specification);
}
