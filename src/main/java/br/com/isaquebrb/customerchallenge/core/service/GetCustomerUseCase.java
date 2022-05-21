package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;

public interface GetCustomerUseCase {

    Customer getById(Long id);
}
