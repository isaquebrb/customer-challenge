package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllCustomerResponse extends BaseResponse {

    private final Long id;
    private final String name;
    private final Integer age;
    private final List<GetAllAddressResponse> addresses;
    private final String email;
    private final String cellphone;
    private final String phone;
    private final Boolean active;

    public GetAllCustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        age = customer.getAge();
        addresses = customer.getAddresses().stream()
                .map(GetAllAddressResponse::new)
                .toList();
        email = customer.getEmail();
        cellphone = customer.getCellphone();
        phone = customer.getPhone();
        active = customer.getActive();
        createdAt = customer.getCreatedAt();
        updatedAt = customer.getUpdatedAt();
    }
}
