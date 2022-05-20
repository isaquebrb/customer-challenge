package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.persistence.CreateCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CreateCustomerPersistence createCustomerPersistence;

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        Customer customer = customerRequest.newCustomer();
        return new CustomerResponse(createCustomerPersistence.save(customer));
    }
}
