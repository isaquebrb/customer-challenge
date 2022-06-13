package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.application.mapper.AddressMapper;
import br.com.isaquebrb.customerchallenge.application.persistence.AddAddressPersistence;
import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.service.AddAddressUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class AddAddressService implements AddAddressUseCase {

    private final AddAddressPersistence addAddressPersistence;

    @Override
    public Address add(Long customerId, Address address) {
        log.info("Adding new address for customer id {}", customerId);
        AddressEntity addressEntity = addAddressPersistence.add(customerId, address);

        return AddressMapper.toDomain(addressEntity);
    }
}
