package br.com.isaquebrb.customerchallenge.core.domain;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.AddressEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Address extends BaseDomain {

    private Long id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public AddressEntity toEntity() {
        return AddressEntity.builder()
                .street(street)
                .number(number)
                .district(district)
                .city(city)
                .state(state)
                .country(country)
                .zipCode(zipCode).build();
    }
}
