package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetAllCustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllCustomersUseCase {

    Page<GetAllCustomerResponse> getAll(Pageable pageable, CustomerFilter customerFilter);
}
