package br.com.isaquebrb.customerchallenge.core.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class AddressTest {

    private final Address address = getAddress();

    public static Address getAddress() {
        return Address.builder()
                .id(new Random().nextLong())
                .street("Random street")
                .number(new Random().nextInt())
                .district("Sta Bronks")
                .city("Harrisburg")
                .state("Pensilvania")
                .country("United States")
                .zipCode("38407998")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
