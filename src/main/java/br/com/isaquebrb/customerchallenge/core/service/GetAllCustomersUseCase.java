package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface GetAllCustomersUseCase {

    Page<CustomerResponse> getAll(Pageable pageable, Specification<CustomerEntity> specification);
}
