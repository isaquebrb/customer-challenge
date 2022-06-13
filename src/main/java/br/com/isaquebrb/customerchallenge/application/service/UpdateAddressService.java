package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.application.persistence.UpdateAddressPersistence;
import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.service.UpdateAddressUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class UpdateAddressService implements UpdateAddressUseCase {

    private final UpdateAddressPersistence updateAddressPersistence;

    @Override
    public void update(Long addressId, Address address) {
        log.info("Updating address id [{}]", addressId);
        updateAddressPersistence.update(addressId, address);
    }
}
