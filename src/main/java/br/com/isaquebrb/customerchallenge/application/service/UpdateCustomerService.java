package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.application.persistence.UpdateCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class UpdateCustomerService implements UpdateCustomerUseCase {

    private final UpdateCustomerPersistence updateCustomerPersistence;

    @Override
    public void update(Long customerId, String name, Integer age, String cellphone, String phone) {
        log.info("Updating customer id {} name, age, cellphone and phone", customerId);
        updateCustomerPersistence.update(customerId, name, age, cellphone, phone);
    }

    @Override
    public void updateEmail(Long customerId, String email) {
        log.info("Updating customer id {} email", customerId);
        updateCustomerPersistence.updateEmail(customerId, email);
    }

    @Override
    public void updateActivation(Long customerId, boolean active) {
        log.info("{} customer id {}", active ? "Disabling" : "Enabling", customerId);
        updateCustomerPersistence.updateActivation(customerId, active);
    }
}
