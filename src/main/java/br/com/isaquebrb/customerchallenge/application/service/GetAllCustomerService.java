package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.Page;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GetAllCustomerService implements GetAllCustomersUseCase {

    private final GetAllCustomerPersistence getAllCustomerPersistence;

    @Override
    public Page<Customer> getAll(Integer page, Integer size, CustomerFilter customerFilter) {
        return getAllCustomerPersistence.getAll(page, size, customerFilter);
    }
}
