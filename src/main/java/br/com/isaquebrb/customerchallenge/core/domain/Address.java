package br.com.isaquebrb.customerchallenge.core.domain;

import lombok.Getter;

@Getter
public class Address extends Interval {

    private Long id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Customer customer;

}
