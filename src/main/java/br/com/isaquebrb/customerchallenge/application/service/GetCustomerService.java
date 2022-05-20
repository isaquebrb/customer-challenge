package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.core.persistence.GetCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.GetCustomerUseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class GetCustomerService implements GetCustomerUseCase {

    private final GetCustomerPersistence getCustomerPersistence;

    @Override
    public GetCustomerResponse getById(Long id) {
        return new GetCustomerResponse(getCustomerPersistence.getById(id));
    }
}
