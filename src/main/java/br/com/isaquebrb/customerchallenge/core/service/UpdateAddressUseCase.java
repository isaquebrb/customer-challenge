package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.core.domain.Address;

public interface UpdateAddressUseCase {

    void update(Long addressId, Address address);
}
