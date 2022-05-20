package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateCustomerResponse;

public interface CreateCustomerUseCase {

    CreateCustomerResponse create(CreateCustomerRequest customerRequest);
}
