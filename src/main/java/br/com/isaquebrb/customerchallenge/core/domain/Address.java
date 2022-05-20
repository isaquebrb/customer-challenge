package br.com.isaquebrb.customerchallenge.core.domain;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import lombok.Getter;
import lombok.Setter;
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

    @Setter
    private Customer customer;

    public AddressEntity newEntity(CustomerEntity customerEntity) {
        return AddressEntity.builder()
                .street(street)
                .number(number)
                .district(district)
                .city(city)
                .state(state)
                .country(country)
                .zipCode(zipCode)
                .customer(customerEntity).build();
    }
}
