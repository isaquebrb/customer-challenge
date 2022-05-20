package br.com.isaquebrb.customerchallenge.core.domain;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class Customer extends BaseDomain {

    private Long id;
    private String name;
    private Integer age;
    private final List<Address> addresses = new ArrayList<>();
    private String email;
    private String cellphone;
    private String phone;
    private Boolean active;

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
    }

    public CustomerEntity newEntity() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(name)
                .age(age)
                .email(email)
                .cellphone(cellphone)
                .phone(phone)
                .active(active).build();

        addresses.stream()
                .map(adr -> adr.newEntity(customerEntity))
                .forEach(customerEntity::addAddress);

        return customerEntity;
    }


}
