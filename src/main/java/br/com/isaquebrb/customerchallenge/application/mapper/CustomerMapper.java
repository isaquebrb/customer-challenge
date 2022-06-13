package br.com.isaquebrb.customerchallenge.application.mapper;

import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;

public interface CustomerMapper {

    static CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmail())
                .cellphone(customer.getCellphone())
                .phone(customer.getPhone())
                .active(customer.getActive())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt()).build();

        customer.getAddresses().stream()
                .map(AddressMapper::toEntity)
                .forEach(customerEntity::addAddress);

        return customerEntity;
    }

    static Customer toDomain(CustomerEntity entity) {
        Customer customer = Customer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .email(entity.getEmail())
                .cellphone(entity.getCellphone())
                .phone(entity.getPhone())
                .active(entity.getActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();

        entity.getAddresses().stream()
                .map(AddressMapper::toDomain)
                .forEach(customer::addAddress);

        return customer;
    }
}
