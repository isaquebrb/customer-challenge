package br.com.isaquebrb.customerchallenge.application.mapper;

import br.com.isaquebrb.customerchallenge.application.persistence.entity.AddressEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Address;

public interface AddressMapper {

    static AddressEntity toEntity(Address address) {

        return AddressEntity.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt()).build();
    }

    static Address toDomain(AddressEntity entity) {

        return Address.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .number(entity.getNumber())
                .district(entity.getDistrict())
                .city(entity.getCity())
                .state(entity.getState())
                .country(entity.getCountry())
                .zipCode(entity.getZipCode())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
