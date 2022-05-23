package br.com.isaquebrb.customerchallenge.adapter.repository.entity;

import java.time.LocalDateTime;
import java.util.Random;

public class CustomerEntityTest {

    public static CustomerEntity getCustomerEntity() {
        return CustomerEntity.builder()
                .id(new Random().nextLong())
                .name("Random customer entity")
                .age(new Random().nextInt())
                .cellphone("34988009090")
                .phone("3432110000")
                .email("customer_entity@teste.com.br")
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
