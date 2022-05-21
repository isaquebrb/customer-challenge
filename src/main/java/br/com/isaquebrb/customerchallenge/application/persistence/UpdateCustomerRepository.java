package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.persistence.UpdateCustomerPersistence;

@PersistenceAdapter
public class UpdateCustomerRepository implements UpdateCustomerPersistence {

    @Override
    public Customer update(String name, Integer age, String cellphone, String phone) {
        return null;
    }

    @Override
    public Customer updateEmail(String email) {
        return null;
    }
}
