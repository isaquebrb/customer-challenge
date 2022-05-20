package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateCustomerResponse {

    private final Long id;
    private final String name;
    private final List<CreateAddressResponse> addresses;
    private final String email;

    public CreateCustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        addresses = customer.getAddresses().stream()
                .map(CreateAddressResponse::new)
                .toList();
        email = customer.getEmail();
    }
}
