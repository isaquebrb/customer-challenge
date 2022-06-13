package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import org.springframework.data.domain.Page;

public interface GetAllCustomerPersistence {

    Page<CustomerEntity> getAll(Integer page, Integer size, CustomerFilter customerFilter);
}
