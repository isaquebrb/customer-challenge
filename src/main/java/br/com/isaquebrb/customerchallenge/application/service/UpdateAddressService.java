package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.service.UpdateAddressUseCase;

@UseCase
public class UpdateAddressService implements UpdateAddressUseCase {

    @Override
    public void update(Long addressId, Address address) {
        //todo implements
    }
}
