package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;

public interface GetCustomerPersistence {

    CustomerEntity getById(Long id);
}
