package br.com.isaquebrb.customerchallenge.core.persistence;

import br.com.isaquebrb.customerchallenge.core.pagination.SimplePage;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;

public interface GetAllCustomerPersistence {

    SimplePage<Customer> getAll(Integer page, Integer size, CustomerFilter customerFilter);
}
