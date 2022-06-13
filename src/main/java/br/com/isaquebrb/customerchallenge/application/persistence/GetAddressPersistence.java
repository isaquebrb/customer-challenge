package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.AddressEntity;

public interface GetAddressPersistence {

    AddressEntity getAddress(Long addressId);
}
