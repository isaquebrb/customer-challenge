package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CustomerResponse;
import br.com.isaquebrb.customerchallenge.commom.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;

@UseCase
public class CreateCustomerService implements CreateCustomerUseCase {

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        return null;
    }
}
