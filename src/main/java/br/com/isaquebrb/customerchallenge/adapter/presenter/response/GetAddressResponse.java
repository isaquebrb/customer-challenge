package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"id", "street", "number", "district", "city",
        "state", "country", "zipCode", "createdAt", "updatedAt"})
public class GetAddressResponse extends BaseResponse {

    private final Long id;
    private final String street;
    private final Integer number;
    private final String district;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;

    public GetAddressResponse(Address address) {
        id = address.getId();
        street = address.getStreet();
        number = address.getNumber();
        district = address.getDistrict();
        city = address.getCity();
        state = address.getState();
        country = address.getCountry();
        zipCode = address.getZipCode();
        createdAt = address.getCreatedAt();
        updatedAt = address.getUpdatedAt();
    }
}
