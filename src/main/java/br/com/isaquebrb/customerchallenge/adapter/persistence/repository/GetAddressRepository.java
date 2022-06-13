package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaAddressRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.GetAddressPersistence;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class GetAddressRepository implements GetAddressPersistence {

    private final JpaAddressRepository jpaAddressRepository;

    @Override
    public AddressEntity getAddress(Long addressId) {
        return jpaAddressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException("address", addressId));
    }
}
