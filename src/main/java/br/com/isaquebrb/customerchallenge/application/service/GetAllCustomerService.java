package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.SimplePage;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class GetAllCustomerService implements GetAllCustomersUseCase {

    private final GetAllCustomerPersistence getAllCustomerPersistence;

    @Override
    public SimplePage<Customer> getAll(Integer page, Integer size, CustomerFilter customerFilter) {
        log.info("Searching customer page");
        return getAllCustomerPersistence.getAll(page, size, customerFilter);
    }
}
