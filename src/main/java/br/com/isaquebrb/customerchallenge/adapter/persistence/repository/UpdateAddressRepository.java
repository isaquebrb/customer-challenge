package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaAddressRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.UpdateAddressPersistence;
import br.com.isaquebrb.customerchallenge.core.domain.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateAddressRepository implements UpdateAddressPersistence {

    private final JpaAddressRepository jpaAddressRepository;
    private final GetAddressRepository getAddressRepository;

    @Override
    public void update(Long addressId, Address address) {
        AddressEntity addressEntity = getAddressRepository.getAddress(addressId);

        addressEntity.update(address.getStreet(), address.getNumber(), address.getCity(),
                address.getDistrict(), address.getState(), address.getCountry(), address.getZipCode());

        jpaAddressRepository.save(addressEntity);

        log.info("Address id [{}] updated successfully", addressId);
    }
}
