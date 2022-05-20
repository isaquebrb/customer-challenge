package br.com.isaquebrb.customerchallenge.core.persistence;

import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GetAllCustomerPersistence {

    List<Customer> getAll(Pageable pageable, CustomerFilter customerFilter);
}
