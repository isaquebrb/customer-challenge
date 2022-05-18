package br.com.isaquebrb.customerchallenge.core.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Customer extends Interval {

    private Long id;
    private String name;
    private Integer age;
    private List<Address> addresses;
    private String email;
    private String cellphone;
    private String phone;
    private Boolean active;

}
