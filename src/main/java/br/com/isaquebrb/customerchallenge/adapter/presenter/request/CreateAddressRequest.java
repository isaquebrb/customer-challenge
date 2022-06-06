package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {

    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address newAddress() {
        return Address.builder()
                .street(street)
                .number(number)
                .district(district)
                .city(city)
                .state(state)
                .country(country)
                .zipCode(zipCode)
                .build();
    }
}
