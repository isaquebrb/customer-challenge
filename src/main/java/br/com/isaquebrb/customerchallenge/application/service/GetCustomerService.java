package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.persistence.GetCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.GetCustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class GetCustomerService implements GetCustomerUseCase {

    private final GetCustomerPersistence getCustomerPersistence;

    @Override
    public Customer getById(Long id) {
        log.info("Searching customer id {}", id);
        return getCustomerPersistence.getById(id);
    }
}
