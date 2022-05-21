package br.com.isaquebrb.customerchallenge.core.persistence;

import br.com.isaquebrb.customerchallenge.core.pagination.Page;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;

public interface GetAllCustomerPersistence {

    Page<Customer> getAll(Integer page, Integer size, CustomerFilter customerFilter);
}
