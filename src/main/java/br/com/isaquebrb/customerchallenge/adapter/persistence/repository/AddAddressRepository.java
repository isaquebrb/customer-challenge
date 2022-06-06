package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaAddressRepository;
import br.com.isaquebrb.customerchallenge.application.mapper.AddressMapper;
import br.com.isaquebrb.customerchallenge.application.persistence.AddAddressPersistence;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class AddAddressRepository implements AddAddressPersistence {

    private final JpaAddressRepository jpaAddressRepository;
    private final GetCustomerRepository getCustomerRepository;

    @Override
    public AddressEntity add(Long customerId, Address address) {
        AddressEntity addressEntity = AddressMapper.toEntity(address);

        CustomerEntity customerEntity = getCustomer(customerId);
        customerEntity.addAddress(addressEntity);

        addressEntity = jpaAddressRepository.save(addressEntity);

        log.info("Address id {} created.", addressEntity.getId());
        return addressEntity;
    }

    private CustomerEntity getCustomer(Long customerId) {
        return getCustomerRepository.getById(customerId);
    }
}
