package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;

public interface CreateCustomerPersistence {

    CustomerEntity save(Customer customerRequest);
}
