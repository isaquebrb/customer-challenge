package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import java.util.Random;

import static br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateAddressRequestTest.getAddressRequest;

public class CreateCustomerRequestTest {

    private final CreateCustomerRequest customerRequest = getCustomerRequest();

    public static CreateCustomerRequest getCustomerRequest() {
        CreateCustomerRequest customerRequest = CreateCustomerRequest.builder()
                .name("Random customer")
                .age(new Random().nextInt(18, 100))
                .cellphone("3488881515")
                .phone("3432220111")
                .email("test@customer.com.br")
                .build();

        CreateAddressRequest addressRequest = getAddressRequest();
        customerRequest.getAddresses().add(addressRequest);
        return customerRequest;
    }
}
