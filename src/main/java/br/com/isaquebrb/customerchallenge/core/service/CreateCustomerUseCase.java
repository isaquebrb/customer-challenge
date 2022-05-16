package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CustomerResponse;

public interface CreateCustomerUseCase {

    CustomerResponse create(CustomerRequest customerRequest);
}
