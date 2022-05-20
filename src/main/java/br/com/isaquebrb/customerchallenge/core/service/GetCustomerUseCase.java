package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;

public interface GetCustomerUseCase {

    GetCustomerResponse getById(Long id);
}
