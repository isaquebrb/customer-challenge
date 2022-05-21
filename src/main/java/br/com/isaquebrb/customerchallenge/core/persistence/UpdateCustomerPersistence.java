package br.com.isaquebrb.customerchallenge.core.persistence;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;

public interface UpdateCustomerPersistence {

    Customer update(String name, Integer age, String cellphone, String phone);

    Customer updateEmail(String email);
}
