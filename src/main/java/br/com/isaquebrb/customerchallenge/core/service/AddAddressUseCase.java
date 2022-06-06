package br.com.isaquebrb.customerchallenge.core.service;

import br.com.isaquebrb.customerchallenge.core.domain.Address;

public interface AddAddressUseCase {

    Address add(Long customerId, Address address);
}
