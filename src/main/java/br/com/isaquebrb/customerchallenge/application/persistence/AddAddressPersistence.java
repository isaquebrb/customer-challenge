package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Address;

public interface AddAddressPersistence {

    AddressEntity add(Long customerId, Address address);
}
