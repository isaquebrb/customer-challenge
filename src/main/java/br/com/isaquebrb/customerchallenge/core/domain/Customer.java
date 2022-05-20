package br.com.isaquebrb.customerchallenge.core.domain;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class Customer extends BaseDomain {

    private Long id;
    private String name;
    private Integer age;
    private List<Address> addresses;
    private String email;
    private String cellphone;
    private String phone;
    private Boolean active;

    public CustomerEntity toEntity() {
        List<AddressEntity> addressEntities = addresses.stream()
                .map(Address::toEntity)
                .toList();

        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(name)
                .age(age)
                .email(email)
                .cellphone(cellphone)
                .phone(phone)
                .active(active).build();

        addressEntities.forEach(customerEntity::addAddress);
        return customerEntity;
    }
}
