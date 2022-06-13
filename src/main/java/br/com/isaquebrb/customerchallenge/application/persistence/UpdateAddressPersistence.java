package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.core.domain.Address;

public interface UpdateAddressPersistence {

    void update(Long addressId, Address address);
}
