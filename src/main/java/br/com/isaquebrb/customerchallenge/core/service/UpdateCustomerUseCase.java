package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;

public interface UpdateCustomerUseCase {

    Customer update(String name, Integer age, String cellphone, String phone);

    Customer updateEmail(String email);
}
