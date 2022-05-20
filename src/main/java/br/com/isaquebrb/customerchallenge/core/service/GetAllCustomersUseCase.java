package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllCustomersUseCase {

    Page<GetCustomerResponse> getAll(Pageable pageable, CustomerFilter customerFilter);
}
