package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.application.persistence.DeleteAddressPersistence;
import br.com.isaquebrb.customerchallenge.core.service.DeleteAddressUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class DeleteAddressService implements DeleteAddressUseCase {

    private final DeleteAddressPersistence deleteAddressPersistence;

    @Override
    public void delete(Long addressId) {
        log.info("Deleting address id [{}]", addressId);
        deleteAddressPersistence.delete(addressId);
    }
}
