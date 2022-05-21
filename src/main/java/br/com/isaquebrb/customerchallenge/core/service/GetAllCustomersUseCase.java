package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.Page;

public interface GetAllCustomersUseCase {

    Page<Customer> getAll(Integer page, Integer size, CustomerFilter customerFilter);
}
