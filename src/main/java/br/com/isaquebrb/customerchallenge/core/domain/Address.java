package br.com.isaquebrb.customerchallenge.core.domain;

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
}
