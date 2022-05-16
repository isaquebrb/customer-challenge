package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.repository.GetAllCustomerRepository;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class GetAllCustomerService implements GetAllCustomersUseCase {

    private final GetAllCustomerRepository getAllCustomerRepository;

    @Override
    public Page<CustomerResponse> getAll(Pageable pageable, Specification<CustomerEntity> specification) {
        Page<CustomerEntity> customersFound = getAllCustomerRepository.getAll(pageable, specification);
        return Page.empty();
    }
}
