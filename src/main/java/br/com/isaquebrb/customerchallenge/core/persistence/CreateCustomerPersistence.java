package br.com.isaquebrb.customerchallenge.core.persistence;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;

public interface CreateCustomerPersistence {

    Customer save(Customer customerRequest);
}
