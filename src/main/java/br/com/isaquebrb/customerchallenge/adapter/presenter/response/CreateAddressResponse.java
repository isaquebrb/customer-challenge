package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import lombok.Getter;

@Getter
public class CreateAddressResponse {

    private final Long id;
    private final String street;
    private final Integer number;
    private final String city;
    private final String zipCode;

    public CreateAddressResponse(Address address) {
        id = address.getId();
        street = address.getStreet();
        number = address.getNumber();
        city = address.getCity();
        zipCode = address.getZipCode();
    }
}
