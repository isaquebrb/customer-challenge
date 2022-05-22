package br.com.isaquebrb.customerchallenge.core.domain;

import java.time.LocalDateTime;
import java.util.Random;

import static br.com.isaquebrb.customerchallenge.core.domain.AddressTest.getAddress;

public class CustomerTest {

    private final Customer customer = getCustomer();

    public static Customer getCustomer() {
        Customer customer = Customer.builder()
                .id(150L)
                .name("Random name")
                .age(new Random().nextInt(18, 100))
                .cellphone("34988997774")
                .phone("3432151545")
                .email("test@customer.com.br")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .active(true).build();

        customer.addAddress(getAddress());
        return customer;
    }
}
