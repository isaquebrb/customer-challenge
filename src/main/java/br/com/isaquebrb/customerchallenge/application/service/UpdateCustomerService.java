package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.application.persistence.UpdateCustomerRepository;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateCustomerService implements UpdateCustomerUseCase {

    private final UpdateCustomerRepository updateCustomerRepository;

    @Override
    public Customer update(String name, Integer age, String cellphone, String phone) {
        return null;
    }

    @Override
    public Customer updateEmail(String email) {
        return null;
    }
}
